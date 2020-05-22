if (!valMap.containsKey(current)) {
            valMap.put(current, 1);

        } else {
            valMap.put(current, valMap.get(current + 1));
        }