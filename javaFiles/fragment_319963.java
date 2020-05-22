List<Set<Pair>> addresses = new ArrayList<Set<Pair>>();
// fill the list of addresses

for (int i = 0; i < 100; i++) {
    Iterator<Pair> it = addresses.get(i).iterator();
    while (it.hasNext()) {
        String m = it.next().getFirst();
    }
}