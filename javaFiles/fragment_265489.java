String xmlnode = "<firstname id=\"{$person.id}\"> {$person.firstname} </firstname>";

Pattern pattern = Pattern.compile("\\{\\$(.*?)\\}");
Matcher matcher = pattern.matcher(xmlnode);

while (matcher.find()) {
    System.out.println(matcher.group(1));
}