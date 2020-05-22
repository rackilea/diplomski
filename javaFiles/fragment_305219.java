String test = "xyz_stringIAmLookingFor_zxy";
Pattern p = Pattern.compile("_(\\w*)_");
Matcher m = p.matcher(test);
while (m.find()) { // find next match
    System.out.println(m.group(1));
}