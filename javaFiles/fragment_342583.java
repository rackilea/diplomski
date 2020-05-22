try {
    f.get();
    System.out.println("f.get() returned");
} finally {
    exec.shutdownNow();
}