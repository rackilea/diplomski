List<String> strings = new ArrayList<String>()
strings.add("lol");
strings.add("cat");

PriorityQueue<String> sortedStrings = new PriorityQueue(strings);
while(!sortedStrings.isEmpty()) {
    System.out.println(sortedStrings.poll());
}
// Prints out "cat" and "lol"