String input = "A-123456-124_VRG.tif";
String pattern = "^[^-]+-[^-]+-([^_]+).*";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(input);

if (m.find()) {
   System.out.println("Found value: " + m.group(1) );
}

124