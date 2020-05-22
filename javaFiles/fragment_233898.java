private static ArrayList<ArrayList<Ticket>> splitList(ArrayList<Ticket> inputList) {
    Map<String, ArrayList<Ticket>> map = new HashMap<>();
    // your ticket categories here
    // (array used for simplicity; you should use a Set, and you should also maintain the valid categories inside your Ticket class, not here)
    String[] categories = new String[] {'a', 'b', 'c' };
    for (int i = 0; i < categories.length; i++) {
        map.put(categories[i], new ArrayList<Ticket>());
    }
    for (int i = 0; i < inputList.size(); i++) {
        Ticket t = inputList.get(i);
        map.get(t.getCategory()).add(t);
    }
    // Convert to list of lists
    return new ArrayList<>(map.values());
}