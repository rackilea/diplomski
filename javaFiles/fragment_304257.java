String s = "G03X-374970Y133680I3100J0*";
Pattern pattern = Pattern.compile("^(G0[1-3])?X(-?[\\d]+)?Y(-?[\\d]+)?I?(-?[\\d]+)?J?(-?[\\d]+)?(D0[1-3])?\\*");

Matcher m = pattern.matcher(s);
while (m.find()) {
    String s = m.group(0);
    System.out.println(s); // prints G03X-374970Y133680I3100J0*
}