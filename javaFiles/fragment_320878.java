try {
size = 0;
while (size >= 0) {
HashMap<String, String> item = new HashMap<String, String>();
item.put(
    ITEM_KEY,
    results.get(size).SSID.toString() + results.get(size).capabilities.toString()
);

arraylist.add(item);
size++;
adapter.notifyDataSetChanged();

} catch (Exception e) {
}