public static void main(String t[]) throws IOException {
    Path exampleFile = Paths.get(PATH_TO_YOUR_EXAMPLE_AS_TEXT);
    String dataAsString = new String(Files.readAllBytes(exampleFile));
    System.out.println(dataAsString);
    System.out.println(dataAsString.replaceAll(":g[^:]*:", ":o"));

}