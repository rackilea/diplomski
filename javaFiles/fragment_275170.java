Map<Integer, Item> items = new HashMap<Integer, Item>();
for (Item itemToRead : file) { // or however you iterate
    items.put(item.getDefindex(), item);
}

// data retrieval
Item itemToRetrieve = items.get(defindexToGet);