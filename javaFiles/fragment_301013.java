public class DecompressibleObjectInputStream extends ObjectInputStream {
    private static Logger logger = LoggerFactory.getLogger(DecompressibleObjectInputStream.class);

    public DecompressibleObjectInputStream(InputStream in) throws IOException {
        super(in);

        try {
            // activating override on readObject thanks to https://stackoverflow.com/a/3301720/535203
            Field enableOverrideField = ObjectInputStream.class.getDeclaredField("enableOverride");

            enableOverrideField.setAccessible(true);

            Field fieldModifiersField = Field.class.getDeclaredField("modifiers");
            fieldModifiersField.setAccessible(true);
            fieldModifiersField.setInt(enableOverrideField, enableOverrideField.getModifiers() & ~Modifier.FINAL);

            enableOverrideField.set(this, true);
        } catch (NoSuchFieldException e) {
            warnCantOverride(e);
        } catch (SecurityException e) {
            warnCantOverride(e);
        } catch (IllegalArgumentException e) {
            warnCantOverride(e);
        } catch (IllegalAccessException e) {
            warnCantOverride(e);
        }
    }

    private void warnCantOverride(Exception e) {
        logger.warn("Couldn't enable readObject override, won't be able to avoid ClassNotFoundException while reading InputStream", e);
    }
    @Override
    public void defaultReadObject() throws IOException, ClassNotFoundException {
        try {
            super.defaultReadObject();
        } catch (ClassNotFoundException e) {
            logger.warn("Potentially Fatal Deserialization Operation.", e);
        }
    }

    @Override
    protected Object readObjectOverride() throws IOException, ClassNotFoundException {
    // copy of JDK 7 code avoiding the ClassNotFoundException to be thrown :
        /*
            // if nested read, passHandle contains handle of enclosing object
        int outerHandle = passHandle;
        try {
            Object obj = readObject0(false);
            handles.markDependency(outerHandle, passHandle);
            ClassNotFoundException ex = handles.lookupException(passHandle);
            if (ex != null) {
                throw ex;
            }
            if (depth == 0) {
                vlist.doCallbacks();
            }
            return obj;
        } finally {
            passHandle = outerHandle;
            if (closed && depth == 0) {
                clear();
            }
        }
         */
        try {
        int outerHandle = getObjectInputStreamFieldValue("passHandle");
        int depth = getObjectInputStreamFieldValue("depth");
        try {
            Object obj = callObjectInputStreamMethod("readObject0", new Class<?>[] {boolean.class}, false);
            Object handles = getObjectInputStreamFieldValue("handles");
            Object passHandle = getObjectInputStreamFieldValue("passHandle");
            callMethod(handles, "markDependency", new Class<?>[] {int.class, int.class}, outerHandle, passHandle);

            ClassNotFoundException ex = callMethod(handles, "lookupException", new Class<?>[] {int.class},  passHandle);

            if (ex != null) {
                logger.warn("Avoiding exception", ex);
            }
            if (depth == 0) {
                callMethod(getObjectInputStreamFieldValue("vlist"), "doCallbacks", new Class<?>[] {});
            }
            return obj;
        } finally {
            getObjectInputStreamField("passHandle").setInt(this, outerHandle);
            boolean closed = getObjectInputStreamFieldValue("closed");
            if (closed && depth == 0) {
                callObjectInputStreamMethod("clear", new Class<?>[] {});
            }
        }
        } catch (NoSuchFieldException e) {
            throw createCantMimicReadObject(e);
        } catch (SecurityException e) {
            throw createCantMimicReadObject(e);
        } catch (IllegalArgumentException e) {
            throw createCantMimicReadObject(e);
        } catch (IllegalAccessException e) {
            throw createCantMimicReadObject(e);
        } catch (InvocationTargetException e) {
            throw createCantMimicReadObject(e);
        } catch (NoSuchMethodException e) {
            throw createCantMimicReadObject(e);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            }
            if (t instanceof IOException) {
                throw (IOException)t;
            }
            throw createCantMimicReadObject(t);
        }
    }

    private IllegalStateException createCantMimicReadObject(Throwable t) {
        return new IllegalStateException("Can't mimic JDK readObject method", t);
    }

    @SuppressWarnings("unchecked")
    private <T> T getObjectInputStreamFieldValue(String fieldName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = getObjectInputStreamField(fieldName);
        return (T) declaredField.get(this);
    }

    private Field getObjectInputStreamField(String fieldName) throws NoSuchFieldException {
        Field declaredField = ObjectInputStream.class.getDeclaredField(fieldName);
        declaredField.setAccessible(true);
        return declaredField;
    }

    @SuppressWarnings("unchecked")
    private <T> T callObjectInputStreamMethod(String methodName, Class<?>[] parameterTypes, Object... args) throws Throwable {
        Method declaredMethod = ObjectInputStream.class.getDeclaredMethod(methodName, parameterTypes);
        declaredMethod.setAccessible(true);
        try {
            return (T) declaredMethod.invoke(this, args);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    @SuppressWarnings("unchecked")
    private <T> T callMethod(Object object, String methodName, Class<?>[] parameterTypes, Object... args) throws Throwable {
        Method declaredMethod = object.getClass().getDeclaredMethod(methodName, parameterTypes);
        declaredMethod.setAccessible(true);
        try {
            return (T) declaredMethod.invoke(object, args);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}