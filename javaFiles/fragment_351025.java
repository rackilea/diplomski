String new_price = "((?:[0-9]{1,3}[\\.,]?)*[\\.,]?[0-9]+)";
String label = "$500.00 - $522.30";
final Pattern p = Pattern.compile(new_price, 0);
final Matcher m = p.matcher(label);
while (m.find()) {
    System.out.println("found! good start");
    if (m.groupCount() == 1) {
        System.out.println("start match price" + " : " + m.group(0));
    }
    if (m.groupCount() == 2) {
        System.out.println("start match price" + " : " + m.group(1));
    }
}