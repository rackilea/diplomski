String nodestr = "<xpath>/Temporary/EIC/SpouseSSNDisqualification</xpath>";
String regex = "<xpath>(.+?)<\/xpath>";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(nodestr);
if (matcher.matches()) {
    String tag_value = matcher.group(1); //taking only group 1
    System.out.println(tag_value); //printing only group 1
}