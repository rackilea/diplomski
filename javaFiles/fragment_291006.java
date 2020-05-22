public static void main(String[] args) {
    try (FileInputStream in = new FileInputStream(new File("myXML.xml"))){
        XMLReader reader = new XMLReader();
        InputStream stream = new BufferedInputStream(in) {
            @Override
            public void close() throws IOException {
               // don't close
            }
        };
        reader.read(stream);
    } catch (Exception e) {
        e.printStackTrace();
    }
}