persistentCount = PersistentStore.getPersistentObject(0xdec6a67096f833cL); 
synchronized (persistentCount) { 
    if (persistentCount.getContents() == null) { 
        persistentCount.setContents(new StoreInfo());
        persistentCount.commit(); 
    } 
}  
_data = (StoreInfo)persistentCount.getContents();