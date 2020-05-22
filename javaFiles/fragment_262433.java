Class<FileDescriptor> clazz = FileDescriptor.class;

    Constructor<FileDescriptor> c;
    try {
            c = clazz.getDeclaredConstructor(new Class[] { Integer.TYPE });
    } catch (SecurityException e) {
            e.printStackTrace();
            return;
    } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return;
    }

    c.setAccessible(true);
    FileDescriptor fd;
    try {
            fd = c.newInstance(new Integer(socket));
    } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return;
    } catch (InstantiationException e) {
            e.printStackTrace();
            return;
    } catch (IllegalAccessException e) {
            e.printStackTrace();
            return;
    } catch (InvocationTargetException e) {
            e.printStackTrace();
            return;
    }

    FileOutputStream os = new FileOutputStream(fd);
    FileInputStream is = new FileInputStream(fd);