public static void main(String[] args) {
    String str = "N4*<address.city>*<address.state>*<address.zipcode>~";
    Pattern p = Pattern.compile("(?:<)(.*?)(?:>)"); // ?: --> non-capturing group..
    Matcher m = p.matcher(str);
    while (m.find()) {
        System.out.println(m.group(1));
    }

}