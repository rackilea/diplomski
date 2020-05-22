List<String> myList = new ArrayList<String>();
//List<String> myList = new LinkedList<String>();

myList.add("One");
myList.add("Two");

// Because we're using a Generic collection, the compiler
// inserts a cast on the next line for you
for (String current : myList) {
    // This section happens once for each elements in myList
    System.out.println(current);
}
// should print "One" and "Two" (without quotes) on separate lines