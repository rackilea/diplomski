List<Double> notes = new ArrayList<>();

// Save all the notes from all the rows
while (rt.next()) {
    notes.add(rt.getDouble("note"));
}

// Print all the notes
// Old-school list traversal style kept from the OP
for(int i = 0; i<notes.size(); i++) {
    System.out.println(notes.get(i));
}