private <T extends people> void populateMap(ConcurrentMap<String, Collection<T>> map) {

                map.put("example", new ArrayList<T>());


    }