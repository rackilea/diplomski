Pattern p = Pattern.compile("^(\\d+)(?=_.*)");

String string = "0_Beginning";

Matcher m = p.matcher(string);
if (m.find()) {
    String digit = m.group(1);
    Integer oneMore = Integer.parseInt(digit) + 1;
    string = m.replaceAll(oneMore.toString());
    System.out.println(string);
} else {
    System.out.println("No match");
}