public static void main(String[] args) throws IOException {
    File file = new File("sample.pdf");
    String hex = toHex(file);
    System.out.println(hex);

}