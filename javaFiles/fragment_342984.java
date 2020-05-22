public static Queue<MyObject> robin(List<MyObject> objects) {

        if(objects.size() == 0) return new LinkedList<>();

        // Group into queues using the getName method
        Map<String, Queue<MyObject>> map = objects.stream()
                .collect(Collectors.groupingBy(MyObject::getName, Collectors.toCollection(LinkedList::new)));

        boolean remaining = true;
        Deque<MyObject> roundRobin = new LinkedList<MyObject>();

        Set<String> keySet = map.keySet();

        // Round robin structure to collect them into a single collection
        while(remaining) {
            remaining = false;
            for(String key : keySet) {
                MyObject obj = map.get(key).poll();
                if(obj == null) continue;
                roundRobin.add(obj);
                remaining = true;
            }
        }

        // Return result
        return roundRobin;
    }