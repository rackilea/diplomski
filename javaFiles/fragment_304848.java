List<String> strings = new ArrayList<String>()
strings.add("lol");
strings.add("cat");

Collections.sort(strings);
for (String s : strings) {
    System.out.println(s);
}
// Prints out "cat" and "lol"