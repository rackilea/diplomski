public static void main(String[] args) {
    String aStringList = "foo\nbar\nbaz";
    String bigRegex = "(" + regexPattern + aStringList.replace("\n", ")|(" + regexPattern) + ")";
    System.out.println(bigRegex);
    // Pattern p = Pattern.compile(bigRegex);
}