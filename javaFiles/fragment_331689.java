List<BazaarItem> items = new ArrayList<>(bazaar.size());
for (String key : bazaar.keys()) {
    JSONObject value = items.getJSONObject(key);

    int id = Integer.parseInt(key);
    int cost = value.getInt("cost");
    int quantity = value.getInt("quantity");
    items.add(new BazaarItem(id, cost, quantity));
}