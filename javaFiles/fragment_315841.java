for (int i = 1; i <= count; i++) {
            if (getList.size() >= i*1000) {
                list = getList.subList((i-1) * 1000, i * 1000);
            } else {
                list = getList.subList((i-1) * 1000, getList.size());
            }
            myMap.put(i, list);
        }