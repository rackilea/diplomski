for (Map.Entry<String,List<date>> entry : mymap.entries()) 
    String key = entry.getKey();
    List<Date> value = entry.getValue();
    if (end_date.compareTo(value.get(1)) > 0) {
        key_set.add(key);
    }
}