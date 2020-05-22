Collections.shuffle(menuItems);
for (int i = 0; i < 5; i++) {
    HashMap<String, String> urls = new HashMap<String, String>();
    urls.put("Value", menuItems.get(i).get(KEY_URL));
    randomitems.add(urls);
}