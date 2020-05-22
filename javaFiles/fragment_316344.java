// Create your list with a proper initial capacity
List<Integer> initgenome = new ArrayList<>(5_000);
// Add the 10 first values
initgenome.addAll(Collections.nCopies(10, 1));
// Add the rest
initgenome.addAll(Collections.nCopies(4990, 0));