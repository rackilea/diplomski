String[] elements = s.toArray(new String[s.size()]);
for (int i = 0; i < elements.length; ++i) {
    String s1 = elements[i];
    // loop through all successive elements
    for (int j = i + 1; j < elements.length; ++j) {
        String s2 = elements[j];
        System.out.println(s1 + " " + s2);
    }
}