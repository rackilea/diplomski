ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream s = new ObjectOutputStream(out);
    try {
        s.writeObject(1);
    } finally {
        IOUtils.closeQuietly(s);
    }