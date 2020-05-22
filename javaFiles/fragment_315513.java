try {
    . . .
} catch (Exception e) {
    e.printStackTrace();

    for (Throwable t = e.getCause(); t != null; t = t.getCause()) {
        System.err.println("Caused by:")
        t.printStackTrace();
    }
}