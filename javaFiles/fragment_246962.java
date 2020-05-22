if (keywordSet.contains(key))
        {
            Integer value = map.get(key);
            if (value == null)
                value = 0;
            value++;
            map.put(key, value);
        }