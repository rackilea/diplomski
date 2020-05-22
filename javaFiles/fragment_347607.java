String line = "\"Transformed\": 10";
String pattern = "Transformed.:.(\\d+)";

Pattern r = Pattern.compile(pattern);

Matcher m = r.matcher(line);

if (m.find()) {
    System.out.println("Found value: " + m.group(0) );
    System.out.println("Found value: " + m.group(1) );
}else {
    System.out.println("NO MATCH");
}