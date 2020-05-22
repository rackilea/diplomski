ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1,100);
        Integer value = map.get(1);
        if (value != null)
            map.computeIfPresent(1, (key, oldValue) -> oldValue + 100);
    }