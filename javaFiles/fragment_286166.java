Pattern p = Pattern.compile("foo");
Matcher matcher = p.matcher("foo bar foo baz foo qux foo");
int count = 0;
while (matcher.find()) {
    count++;
}
System.out.println("Count: " + count); // count == 4