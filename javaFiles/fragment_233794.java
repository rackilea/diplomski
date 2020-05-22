List<String> alphabet = new ArrayList<String>();
alphabet.add("A");
alphabet.add("B");
alphabet.add("C");
alphabet.add("D");
alphabet.add("E");
alphabet.add("F");
alphabet.add("G");
// Etc..
List<String> toRemove = Arrays.asList("B", "F"); // Takes varargs!

alphabet.removeAll(toRemove);

System.out.println(alphabet); // A, C, D, E, G