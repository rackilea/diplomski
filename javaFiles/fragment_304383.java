Hashtable<String, Integer> gettingStatus = searchActiveAssetStatus();
    ArrayList<String> statusValue = new ArrayList<String>();
    ArrayList<String> statusCount = new ArrayList<String>();
    Set<String> keys = gettingStatus.keySet();
    for (String key : keys) {
        if (key.contains("Active") || key.contains("Abandoned") || key.contains("Deleted")) {
            statusValue.add(key);
            statusCount.add(gettingStatus.get(key).toString());
        }
    }