try {
    ...
} catch (Throwable e) {
    e.printStackTrace();
    throw new RuntimeException(e);
}