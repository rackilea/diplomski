public static void main(String[] args) {
    String word= "bla_bla_test_1023";
    Pattern p = Pattern.compile("(?<=_)([^_]+)(?=_\\d+)");
    Matcher m = p.matcher(word);
    while (m.find()) {
        System.out.println(m.group());
    }


}