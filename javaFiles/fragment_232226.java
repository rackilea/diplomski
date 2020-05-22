Map<String, Integer> map = new HashMap<String, Integer>();
        while(s.hasNext()) {
            String key = s.next();
            int value = Integer.parseInt(s.next());
            if(map.containsKey(key)) {
                if(value>map.get(key))
                    map.put(key, value);
            }else map.put(key, value);
        }
        System.out.println("Map="+map);
    }