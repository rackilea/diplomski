Set<Project> projects = new TreeSet<>((o1, o2) -> {
    if (o1.getLabel().equals("foo")) return -2;
    if (o1.getLabel().equals("Solar")) return -1;
    if (o1.getLabel().equals("Gov")) return 1;
    return 0;
});