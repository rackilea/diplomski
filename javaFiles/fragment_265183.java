static String readFile(String path, Charset encoding) throws IOException{
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    String x =  new String(encoded, encoding);
    int count = 0;
    for(char ch: x.toCharArray()){
        System.out.println(ch + " " + ++count );
    }
    return x;
}