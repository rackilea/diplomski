public static void main(String[] args) {
    String sen = "I am fine today";
    String[] sen2 = {"how are (.*?) to day", "I am (.*?) today", "thank (.*?) for your answer"};
    Pattern pattern;
    Matcher matcher;
    for (String s : sen2) {
        pattern = Pattern.compile(s);
        matcher = pattern.matcher(sen);
        if (matcher.find()) {
            System.out.println("Yes found : " + matcher.group(1));
        }
    }
}