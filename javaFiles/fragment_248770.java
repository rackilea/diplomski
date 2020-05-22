final List<String> animals = new ArrayList<>();
animals.add("Kangaroo");
animals.add("Manatee");
animals.add("Tauntaun");

for (final String creature : animals) {
    System.out.println(creature);
}
System.out.println();

final Iterator<String> iter = animals.iterator();

while (iter.hasNext()) {
    final String creature = iter.next();

    if (creature.equals("Manatee")) {
        iter.remove();
    }
}

for (final String creature : animals) {
    System.out.println(creature);
}
System.out.println();