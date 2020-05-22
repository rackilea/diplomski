Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String key1, String key2) {
            return order.indexOf(key1) - order.indexOf(key2);
        }
    };