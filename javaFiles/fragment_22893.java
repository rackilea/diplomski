List<String> names = new ArrayList<>();
names.add("Nate");
names.add("Sunmi");
names.add("Tony");
for (String name : names) {
    System.out.println(name); // Sunmi, Nate, Tony
}
System.out.println("-------");
names.remove("Nate");
for (String name : names) {
    System.out.println(name); // Sunmi, Tony
}
System.out.println("-------");
names.remove(0);
for (String name : names) {
    System.out.println(name); // Tony
}