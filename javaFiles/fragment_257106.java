List<String> list = Arrays.asList("one", "two", "three");
StringJoiner sj = new StringJoiner(",");
for (String s : list) {
    sj.add(s);
}
System.out.println(sj.toString());