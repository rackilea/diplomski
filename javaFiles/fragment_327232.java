public static void main(String[] args) {
    Byte[] b = new Byte[1000];
    Runtime runtime = Runtime.getRuntime();

    long allocatedMemory = runtime.totalMemory() - runtime.freeMemory();
    System.out.println(allocatedMemory);

    List<Byte[]> collection = new ArrayList<>();
    collection.add(b);

    allocatedMemory = runtime.totalMemory() - runtime.freeMemory();
    System.out.println(allocatedMemory);
}