ArrayList<HashMap<Integer, Double>> eMatrix = new ArrayList<HashMap<Integer, Double>>();
while (i < foo.size() - 1) {
    HashMap<Integer, Double> row = new HashMap<Integer, Double>();
    if (foo.get(i) == 0) {
        row.put(0, foo.get(i));
    }
    if (foo.get(i) == 1) {
        ro.put(1, foo.get(i));
    }
    if (foo.get(i) == 2) {
        ro.put(2, foo.get(i));
    }
    if (!row.isEmpty()) {
        eMatrix.add(row);
    }
    i++;
}