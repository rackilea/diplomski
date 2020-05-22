TreeSet<String> set = new TreeSet<String>();
set.add("lol");
set.add("cat");
// automatically sorts natural order when adding

for (String s : set) {
    System.out.println(s);
}
// Prints out "cat" and "lol"