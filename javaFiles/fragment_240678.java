// Original:
public void test() throws IOException {
    try (final StringWriter writer = new StringWriter()) {
        writer.write("This is only a test.");
    }
}

// Decompiled:
public void test() throws IOException {
    final StringWriter writer = new StringWriter();
    Throwable t = null;
    try {
        writer.write("This is only a test.");
    }
    catch (Throwable t2) {
        t = t2;
        throw t2;
    }
    finally {
        if (writer != null) {
            if (t != null) {
                try {
                    writer.close();
                }
                catch (Throwable t2) {
                    t.addSuppressed(t2);
                }
            }
            else {
                writer.close();
            }
        }
    }
}