public static void main(String[] args) {
    matchAndExtract("Hello my name is <NAME> and I am from <CITY>", "Hello my name is Ben and I am from New York");
}

public static void matchAndExtract(String s1, String s2) {
    List<String> placeHolderNames = new ArrayList<>();

    Pattern p1 = Pattern.compile("(?<=<)[^<>]+(?=>)");
    Matcher m1 = p1.matcher(s1);
    while (m1.find()) {
        placeHolderNames.add(m1.group());
    }

    Pattern p2 = Pattern.compile(s1.replaceAll("<.*?>", "(.*)"));
    Matcher m2 = p2.matcher(s2);
    if (m2.matches()) {
        System.out.println("Both string matches");
        for (int i = 0; i < m2.groupCount(); i++) {
            System.out.println(placeHolderNames.get(i) + " = " + m2.group(i + 1));
        }
    } else {
        System.out.println("Both string doesn't match");
    }
}