class MyClass {
    static byte[] theData; 
    static {
        try { 
            theData = ByteStreams.toByteArray(MyClass.class.getClassLoader().getResourceAsStream('/myBigResource.dat'))
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
     ...
}