try {
            writeObjectMethod.invoke(obj, new Object[]{ out });
        } catch (InvocationTargetException ex) {
            Throwable th = ex.getTargetException();
            if (th instanceof IOException) {
                throw (IOException) th;
            } else {
                throwMiscException(th);
            }
        }

// ...

private static void throwMiscException(Throwable th) throws IOException {
    if (th instanceof RuntimeException) {
        throw (RuntimeException) th;
    } else if (th instanceof Error) {
        throw (Error) th;
    } else {
        IOException ex = new IOException("unexpected exception type");
        ex.initCause(th);
        throw ex;
    }
}