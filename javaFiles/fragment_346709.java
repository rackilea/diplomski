try {
        int i = 0;
        if (i == 1) {
            throw new IOException("wont be thrown");
        }
        throw new RuntimeException("boom");
    } catch(IOException e) {
        System.out.println("Got an exception");
    } finally {
        return "a result";
    }