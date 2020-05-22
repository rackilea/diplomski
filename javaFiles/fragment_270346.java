if (list != null) {
    for (HashMap<String, String> map : list) {
        for (Entry<String, String> mapEntry : map.entrySet()){
            String key = mapEntry.getKey();
            String value = mapEntry.getValue();
            Log.i("PROJECTCARUSO", "key: "+ key + " value:" + value);
        }
    }
}