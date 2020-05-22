List<String> sa = new ArrayList<>();

sa.add(root.data.getLastName().toString();

for (int i = 0; i < sa.size(); ++i) { // Old-style, if you need the index i
    String s = sa.get(i);
    ...
    sa.set(i, s + s);
}

for (String s : sa) {
    System.out.println(s);
}