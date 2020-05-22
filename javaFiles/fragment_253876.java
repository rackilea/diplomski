Map<String, String> map = objectMapper.convertValue(emp, HashMap.class);

        Map<String, Object> myMap = new HashMap<String, Object>();
        if (null != map && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet())
                myMap.put(entry.getKey(), entry.getValue());
        }