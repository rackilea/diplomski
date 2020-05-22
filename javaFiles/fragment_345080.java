public static void main(String[] args) {
    String infoString = "[03/12/13 10:00][30][John Smith][5554215445][#Comment]";
    final Pattern pattern = Pattern.compile("\\[#?(.+?)\\]");
    final Matcher matcher = pattern.matcher(infoString);
    while (matcher.find()) {
        System.out.println(matcher.group(1));
    }
}