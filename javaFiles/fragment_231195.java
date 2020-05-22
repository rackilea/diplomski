Set<String> uniqueCategories = new TreeSet<>();

// Accumulate the unique categories
// Note that Set.add will do nothing if the item is already contained in the Set.
for(Checkout c : checkOutArrayList) {
    uniqueCategories.add(c.getCategory());
}

// Print them all out (just an example)
for (String category : uniqueCategories) {
    System.out.println(category);
}