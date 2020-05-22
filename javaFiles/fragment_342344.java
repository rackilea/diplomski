ArrayList<String> listOfDataItems = new ArrayList<String>();
 for(String key: dataMap.keySet())
 {
    Object value = get(key);
    if(value instanceof Long)
    {
        listOfDataItems.add(String.valueOf(value));
    }
    else if(value instanceof String)
    {
        listOfDataItems.add(value);
    }
 }
 String [] arrayOfDataItems = listOfDataItems.toArray(new String[listOfDataItems.size()]);