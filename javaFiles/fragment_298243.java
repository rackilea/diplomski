public static void main(String[] args) {
    String example = "(((1+2))-((5+6))-((10+20))-((6-18))+((9+10)))";


    List<String> firstList = new ArrayList<>();
    Pattern pattern = Pattern.compile("\\(|\\)|\\+|\\-|\\*|\\\\|\\d+"); // the back slashes are used for escaping
    Matcher matcher = pattern.matcher(example);
    while (matcher.find()) {
        firstList.add(matcher.group());
    }

    // second way:
    List<String> secondList = Arrays.asList(
            example.split("(?<!\\d)(?!\\d)|(?<=\\d)(?!\\d)|(?<!\\d)(?=\\d)"));

    // third way
    List<String> thirdList = new ArrayList<>();
    char[] chars = example.toCharArray();
    for (int index = 0; index < chars.length; ) {
        if (!Character.isDigit(chars[index])) {
            thirdList.add(String.valueOf(chars[index])); // put into list if not digit
            index++;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            while (Character.isDigit(chars[index])) {  // loop to get a complete number
                stringBuilder.append(chars[index]);
                index++;
            }
            thirdList.add(stringBuilder.toString());
        }
    }
}