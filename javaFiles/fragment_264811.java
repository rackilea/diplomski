HashMap<Item, Object[]> myHashMap = new HashMap<Item, Object[]>(1400);

        public int addItem(Item item, int n) {
            //...
            Object[] itemBundle = myHashMap.get(item.uniqueID);
            if (itemBundle == null) {
                itemBundle = new Object[2];
                itemBundle[0] = item;
                itemBundle[1] = new Integer(n);
            }
            else {
                itemBundle[2] = new Integer((Integer)itemBundle[2] + n);
            }
            myHashMap.put(item.uniqueID, itemBundle);
            //...
        }

        public int quantityOf(String itemID) {
            return myHashMap.getOrDefault(itemID, 0);
        }

        public boolean isInLocker(String itemID) {
            return myHashMap.containsKey(itemID);
            //or return this.quantityOf(itemID) > 0;
        }