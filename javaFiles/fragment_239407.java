Pattern pattern = Pattern.compile("\\((-?\\d+),(-?\\d+)\\)");
Matcher matcher = pattern.matcher("(8,0),(0,-1),(7,-2),(1,1)");

while (matcher.find()) {
   int x = Integer.parseInt(matcher.group(1));
   int y = Integer.parseInt(matcher.group(2));
   System.out.printf("x=%d, y=%d\n", x, y);
}