public static void main(String[] args) {
    String s = "%getProductName%-%GetProductCode%[-]*[0-9]*\\.(.+)";
    Pattern p = Pattern.compile("%(.*?)%"); // capturing group to extract data between ()s
    Matcher m = p.matcher(s);
    while (m.find()) {
        System.out.println(m.group(1));
    }

}