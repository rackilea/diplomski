Map<String, Integer> totals = new HashMap<>();

for (int i = 0; i < nameArray.size(); ++i) {
    String name = nameArray.get(i);
    int price = priceArray.get(i);

    Integer total = totals.get(name);

    if (total != null) {
        totals.put(name, total + price);
    } else {
        totals.put(name, price);
    }
}