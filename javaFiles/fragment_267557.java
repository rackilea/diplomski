public static void main(String args[]) throws Exception {
    Serializer serializer = new Persister(new Format("<?xml version=\"1.0\" encoding= \"UTF-8\" ?>"));
    File source = new File("sample.xml");
    Issues i = serializer.read(Issues.class, source);

}