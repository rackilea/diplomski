List<Integer> al = Arrays.asList( // First, get a
                                  // List of Integers.
    new Integer[] { 10, 7, 9, 3 }); // From the question
System.out.println(al); // print the List.
for (int i = 0; i < al.size(); i++) {
  Integer v = al.get(i); // get the element.
  v = v - 1; // Update the value.
  al.set(i, v); // Update the List.
}
System.out.println(al); // print the List.