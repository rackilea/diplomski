public static void sampleFunction(String name, Object... args) {
    System.out.println (args.length);
}

sampleFunction("x", new byte[] {1,2,3});
sampleFunction("x", new Byte[] {1,2,3});