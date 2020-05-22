public static void main(String[] args) {
    String text = "Some Text;Some Text again #A comment;#A comment line;Another Text;Another Text again#Comment";
    System.out.println(text);
    text = text.replaceAll("#[^;]*", "");
    System.out.println(text);
}