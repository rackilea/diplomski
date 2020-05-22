public static void main(String[] args) {
    final String regex = "([a-zA-Z0-9öÖäÄüÜß]+\\s){3}|([a-zA-Z0-9öÖäÄüÜß]+\\s){1,2}";
    final String string = "Hello my name is Tom and i love playing football\n\n";

    final Pattern pattern = Pattern.compile(regex);
    final Matcher matcher = pattern.matcher(string);
    int count = 0;
    while (matcher.find()) {
        ++count;
        System.out.println("match:" + count + " " + matcher.group(0));
    }