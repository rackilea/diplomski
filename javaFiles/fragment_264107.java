String s = "Level I (10/20)";

Pattern pattern = Pattern.compile("\\(\\d+/(\\d+)\\)");
Matcher matcher = pattern.matcher(s);

if (matcher.find()) {
    System.out.println(matcher.group(1));
}