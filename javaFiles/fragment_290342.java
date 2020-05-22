...
    Iterator i = valueIterator(map);
    while(i.hasNext()) {
        System.out.println(i.next());
    }
...
    Iterator valueIterator(TreeMap map) {
        Set set = new TreeSet(new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
                return  o1.getValue().compareTo(o2.getValue()) > 0 ? 1 : -1;
            }
        });
        set.addAll(map.entrySet());
        return set.iterator();
    }