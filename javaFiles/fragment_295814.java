if (myStores.getStoreNumber().equals(myStores.getStoreNumber())) {                      
    myCache.put(myStores, hardware.getHardwareInfo_East()); //myCache is a static map.
    myCache.put(myStores, hardware.getHardwareInfo_West());
    myCache.put(myStores,hardware.getHardwareInfo_South());
    myCache.put(myStores,hardware.getHardwareInfo_North());
    break;
}