HashMap<String, ItemWrapper> myHashMap = new HashMap<String, ItemWrapper>(1400);

        public int addItem(Item item, int n) {
            //...
            ItemWrapper wrappedItem = myHashMap.get(item.uniqueID);
            if (wrappedItem == null) {
                wrappedItem = new ItemWrapper(item, n);
            }
            else {
                wrappedItem.quantity += n;
            }
            myHashMap.put(item.uniqueID, wrappedItem);
            //...
        }

        public int quantityOf(String itemID) {
            ItemWrapper wrappedItem = myHashMap.get(itemID);
            return wrappedItem == null ? 0 : wrappedItem.quantity;
        }

        public boolean isInLocker(String itemID) {
            return myHashMap.containsKey(itemID);
            //or return this.quantityOf(itemID) > 0;
        }