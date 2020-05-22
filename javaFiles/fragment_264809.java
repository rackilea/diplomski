HashMap<Item, Integer> myHashMap = new HashMap<Item, Integer>(1400);

        public int addItem(Item item, int n) {
            //...
            int currentCount = myHashMap.getOrDefault(item, 0);
            myHashMap.put(item, n + currentCount);
            //...
        }

        public int quantityOf(Item item) {
            return myHashMap.getOrDefault(item, 0);
        }

        public boolean isInLocker(Item item) {
            return myHashMap.containsKey(item);
            //or return this.quantityOf(item) > 0;
        }