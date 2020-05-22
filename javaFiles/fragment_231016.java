String value = "    New Requestmumbai  04/23/2016 you location 0123456789\n" +
    "\n" +
    "User  Admin Check  via mail.drop.com";

Pattern p = Pattern.compile("\\s(\\d{10})\\s");
Matcher m = p.matcher(value);
while (m.find()) {
    String ph = m.group(1);
    System.out.printf(ph);
}