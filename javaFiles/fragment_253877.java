Map<String, Object> myMap = null;
        if (null != map && map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet())
                if (entry.getValue() instanceof java.util.Map) {
                    myMap = (Map<String, Object>) entry.getValue();
                }
        }