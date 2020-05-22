Set<Entry<String, Integer>> set = wordCount.entrySet();
    List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o2.getValue().compareTo(o1.getValue());
        }
    });

    int topResults = 5;
    Iterator<Entry<String, Integer>> iter = list.iterator(); //refer the sorted collection
    while (iter.hasNext() && topResults > 0 ) {
        Map.Entry<String, Integer> entry = iter.next();
        System.out.println(entry.getKey() + "->" + entry.getValue());
        topResults --;
    }