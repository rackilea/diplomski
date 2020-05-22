public static void main(String[] args) throws IOException {
    String str = "internet address : http://test.com Click this!";
    String first = str.substring(str.indexOf("http://"));
    String second = first.substring(0, first.indexOf(" "));
    System.out.println(second);
}