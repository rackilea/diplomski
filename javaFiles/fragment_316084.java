for (int i = -3; i < 3; i++) {
    set.add(i);
    list.add(i);
}
System.out.println("After adding elements:");
System.out.println(set + " " + list);

for (int i = 0; i < 3; i++) {
    set.remove(i);
    list.remove(i);
}