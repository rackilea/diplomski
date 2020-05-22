// this sorts the vector by first keys
    Collections.sort(returnMaps, new Comparator<SortedMap<String,String>>() {
        public int compare(SortedMap<String,String> a, HashMap<String,String> b) {
            return a.firstKey().compareTo(b.firstKey());
        }
    });