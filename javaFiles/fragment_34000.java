// Using classic try/catch/finally
    Reader r = null;
    try {
        r = new FileReader(...);
        // use the reader
    } catch (IOException ex) {
        // ...
    } finally {
        if (r != null) {
            try {
                r.close();
            } catch (IOException ex) {
                // ignore
            }
        }
    }