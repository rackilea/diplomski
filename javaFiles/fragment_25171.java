String[] strings = {"aabcccdee", "abbabba", "abbd "};
for (String str : strings) {
    Pattern pattern = Pattern.compile("([a-z])\\1");

    // While the input contain more than one consecutive char make a replace
    while (pattern.matcher(str).find()) {
        // Note : use replaceFirst instead of replaceAll
        str = str.replaceFirst("(.)\\1+", "");
    }
    System.out.println(str);
}