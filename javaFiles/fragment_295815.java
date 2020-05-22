if (myStores.getStoreNumber().equals(myStores.getStoreNumber())) {                      
    myCache.put(myStores, new ArrayList<String>(hardware.getHardwareInfo_East())); //myCache is a static map.
    List<String> list = myCache.get(myStores);
    list.addAll(hardware.getHardwareInfo_West());
    list.addAll(hardware.getHardwareInfo_South());
    list.addAll(hardware.getHardwareInfo_North());
    break;
}