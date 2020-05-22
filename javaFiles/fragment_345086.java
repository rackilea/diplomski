public static void main(String[] args) throws FileNotFoundException {
    String test = "OBC9187A-1%A";
    Pattern p = Pattern.compile("\\d.*\\d");
    Matcher m = p.matcher(test);

    while (m.find()) {
        System.out.println("Match: " + m.group());
    }
}