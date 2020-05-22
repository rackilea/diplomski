public static ArrayList<String> getPhones(String s) {
    String regex = "[0-9]{13}";

    ArrayList<String> array = new ArrayList<String>();

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(s);

    while (matcher.find()) {
        array.add(s.substring(matcher.start(), matcher.end()));
    }

    return array;
}