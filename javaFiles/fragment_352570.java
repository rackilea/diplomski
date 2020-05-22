String regex = ".*(\\d+-\\d+).*(\\d+-\\d+).*";
String text = "Adds (4-5) to (8-9) Physical Damage";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(text);

System.out.println(matcher.matches());