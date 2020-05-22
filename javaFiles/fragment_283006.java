public static void main(String[] args) {
    String condition1 = "S(GLHOLD) AND S(GLSHOVE) OR S(PLINK) OR S(PSHARE) AND S(PSTT) AND S(PNET)";
    String condition2 = "S(GLHOLD) AND S(GLSHOVE) OR S(PLINK)OR S(PSHARE) AND S(PSTT) AND S(PNET)";
    String condition3 = "S(GLHOLD) ANDS(GLSHOVE) OR S(PLINK) OR S(PSHARE) AND S(PSTT) AND S(PNET)";

    List<String> shuoldBeSeparated = Arrays.asList("OR", "AND");
    System.out.println(containsSeparated(condition1, shuoldBeSeparated));
    System.out.println(containsSeparated(condition2, shuoldBeSeparated));
    System.out.println(containsSeparated(condition3, shuoldBeSeparated));
    System.out.println(containsSeparated("A AND B ORCC", shuoldBeSeparated));
    System.out.println(containsSeparated("A AND D", shuoldBeSeparated));
    System.out.println(containsSeparated("A AND B OR C", shuoldBeSeparated));
}

public static boolean containsSeparated(String condition, List<String> keywords) {
    for (String word : keywords) {
        Pattern p = Pattern.compile("\\S" + word + "|" + word + "\\S");
        Matcher matcher = p.matcher(condition);
        boolean foundNotSeparated = matcher.find();
        if (foundNotSeparated) {
            return false;
        }
    }
    return true;
}