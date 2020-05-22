Map<String, Integer> counts = new HashMap<>();
for (String elem : list) {
    Integer count = counts.get(elem);
    if (count == null) {
        counts.put(elem, 1);
    } else {
        counts.put(elem, count + 1);
    }
}

Iterator<String> it = list.iterator();
while (it.hasNext()) {
    int count = counts.get(it.next());
    if (count > 1) {
        it.remove();
    }
}