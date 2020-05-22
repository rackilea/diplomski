public static void main(String[] args) {
    Metadata meta = new Metadata();
    String filename = "C:\\Users\\luckheart\\Pictures\\Sample Pictures\\Koala.jpg";
    if (new File(filename).exists()) {
        meta.readAndDisplayMetadata(filename);
    } else {
        System.out.println("cannot find file: " + filename);
    }
}