public static void main(String[] args) {
    StringBuilder sb = new StringBuilder("This is ");
    sb.append("my book");
    String s1 = sb.toString();
    String s2 = "This is my book";
    System.out.println(s1 == s2);
}