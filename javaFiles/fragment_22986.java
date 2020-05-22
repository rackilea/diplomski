Iterator<String> itr1 = s.iterator();
Set<String> used = new HashSet<>(); // track the elements that have been used in the first column
while (itr1.hasNext()) {
    Iterator<String> itr2 = s.iterator(); // a new iterator
    String s1 = itr1.next();
    used.add(s1); // track what we've used
    while (itr2.hasNext()) {
        String s2 = itr2.next();
        if (used.contains(s2));
            continue; // we've alread used s2
        System.out.println(s1 + " " + s2);
    }
}