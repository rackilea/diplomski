Pattern pattern = Pattern.compile("(?<![.a-zA-Z])num(\\d)\\..*");
Matcher matcher = pattern.matcher("+(num3.bar)");

if (matcher.find()) {
    System.out.println(matcher.start() + " : " + matcher.group(1));
}