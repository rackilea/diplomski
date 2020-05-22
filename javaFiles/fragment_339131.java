Map<Integer, Double> sortedMap = new TreeMap<Integer, Double>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return map.get(o2).compareTo(map.get(o1)); // reverse order of values
        }
    });
    sortedMap.putAll(map);