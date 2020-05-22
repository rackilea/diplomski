public static void main(String[] args) throws IOException {
    // TODO code application logic here
    String book;
    book= readFile("Book.txt",Charset.defaultCharset());

    String[] ch = book.split("CHAPTER");

    System.out.println(ch[2]); //prints chapter two
}
static String readFile(String path, Charset encoding) 
    throws IOException 
{
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, encoding);
}