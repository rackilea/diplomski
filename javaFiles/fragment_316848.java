public static void main(String[] args) {
    String newString = "[{124}, {126}, {12, 14}, {13, 18, 130, 113}]";
    Pattern p = Pattern.compile("\\{(.*?)\\}");
    Matcher m = p.matcher(newString);
    while(m.find())
    {
        System.out.println(m.group(1).replace(",", ""));
    }
}