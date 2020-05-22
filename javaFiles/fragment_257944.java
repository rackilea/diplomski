private void doOutOfMemory() {
    try {
        List<byte[]> list = new ArrayList<byte[]>();
        while (true) {
            list.add(new byte[200 * 1024 * 1024]);
        }
    } catch (OutOfMemoryError ex) {
    }
}