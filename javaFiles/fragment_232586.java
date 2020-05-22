Matcher ma = Pattern.compile("(?:\\s*(?:\\\"([^\\\"]*)\\\"|([^,]+))\\s*,?)+?").matcher("   \"  ab  cd  \" ,    \"  efgh,ijk.\",  4,\"lmno\"");
while (ma.find()) {
    if (ma.group(1) == null) {
        System.out.println(ma.group(2));
    } else {
        System.out.println(ma.group(1));
    }
}