for (Integer key : duplicates.keySet()) {
    Collection<Path> paths = duplicates.getCollection(key);
    System.out.println("Paths for " + key);
    for (Path path : paths) {
        System.out.println("  " + path);
    }
    System.out.println();
}