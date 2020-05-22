String input = "__YOUR__VCARDS__";
Pattern pattern = Pattern.compile("(BEGIN:VCARD.*?END:VCARD)", Pattern.DOTALL);
Matcher m = pattern.matcher(input);
while (m.find()) {
    System.out.println(m.group(1));
}