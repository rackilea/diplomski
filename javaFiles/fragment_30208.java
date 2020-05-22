a.add("One");
b.add(a);

a = new ArrayList<>(a); // assuming you want the second list to contain both "One" and "Two"
a.add("Two");
b.add(a);