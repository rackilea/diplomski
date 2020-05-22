String test1[] = { "Diamond", "Iron", "Leather" };
String test2[] = { "Leggings", "Boots", "Helmet", "Chestplate" };
List<String> al = new ArrayList<>();
for (String i : test1) {
    for (String j : test2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(' ').append(j);
        al.add(sb.toString());
    }
}
System.out.println(al);