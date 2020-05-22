Collections.sort(list, new Comparator<Map<String, Object>>() {
        public int compare(Map<String, Object> map1, Map<String, Object> map2) {
            Date date1 = (Date) map1.get("Date");
            Date date2 = (Date) map2.get("Date");
            return date1.compareTo(date2);
        }
    });