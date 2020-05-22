List<Item> itemsOnPage = new ArrayList<Item>(); 
    String content = readUrl("https://rsbuddy.com/exchange/summary.json");  
    Gson gson = new GsonBuilder().create();
    // the json value in content is like key-value pair which can be treated as a map 
    // {2: item1, 3: item2, 4: item4, .....}
    HashMap<String, Object> items = new HashMap<>();
    items = (HashMap<String, Object>) gson.fromJson(content, items.getClass());
    for (String key : items.keySet()) {
        // Once you have converted the json into a map and since the value associated 
        // with it is also a set of key-value pairs it is treated as LinkedTreeMap
        LinkedTreeMap<String, Object> itemMap = (LinkedTreeMap<String, Object>) items.get(key);
        // convert it back to json representation to that we could 
        // parse it to an object of the Item class
        String itemString = gson.toJson(itemMap);
        // what we have now in itemString is like this:
        // {"id": 2, "name": "Cannonball", "buy_average": 191, "overall_average": 193, "sell_average": 192}
        Item item = new Item();
        item = gson.fromJson(itemString, item.getClass());
        // add the current item to the list
        itemsOnPage.add(item);
    }