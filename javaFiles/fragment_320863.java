String str = "MSH|^~\\&|Unicare^HL7CISINV10.00.16^L||IBA||||ADT^A03|3203343722|P|2.3.1|||||\r\nEVN|A03\r";;
String[] ss = str.split("\\|+");
for (String s : ss) {
    System.out.println("Split..: \"" + s + "\"");
}
Pattern pattern = Pattern.compile("[^|]+");
Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
   System.out.println("Pattern: \"" + matcher.group() + "\"");
}