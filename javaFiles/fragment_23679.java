Iterator<Entry<String, Integer>> itr = map.entrySet().iterator();
    if(itr.hasNext())
        itr.forEachRemaining(new Consumer<Entry<String, Integer>>() {
            public void accept(Entry<String, Integer> t) {
                System.out.println(t.getKey() +" --> " + t.getValue());
            }
        });