private static void printAllClasses(
        Map<String, Set<String>> hierarchy, String parent, String i) {
    hierarchy.getOrDefault(parent, Collections.emptySet())
        .forEach(x -> {
            System.out.println(i+x);
            printAllClasses(hierarchy, x, i+"  ");
    });
}