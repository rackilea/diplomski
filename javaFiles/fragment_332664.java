public static Map removeHoliday(ConcurrentHashMap daysMap, Map holydayMap) {
        Iterator<Map.Entry> holyDayiterator = holydayMap.entrySet().iterator();
        while (holyDayiterator.hasNext()) {
            Map.Entry holyDayEntry = holyDayiterator.next();
            if(daysMap.containsKey(holyDayEntry.getKey())){
                daysMap.remove(holyDayEntry.getKey());
            }
        }
        return daysMap;
    }