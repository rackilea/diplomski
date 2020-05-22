Scanner s = new Scanner(str);
s.useDelimiter(Pattern.compile("/{1,2}"));
while (s.hasNext()) {
    System.out.println(s.delimiter());
    System.out.println(s.next());
}