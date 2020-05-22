public void doSomething(MyObj id){
    // see https://stackoverflow.com/q/322715/2711488
    List<Map<String, List<String>>> mapsList = new ArrayList<>();

    for(Map.Entry<MyObj, Map<String, List<String>>> e: conMap.entrySet()){              
        if(e.getKey().key1.equals(id.key1)){
            mapsList.add(e.getValue());
        }
    }

    for(Map<String, List<String>> map: mapsList){
        synchronized(map) {
            //...
        }
    }
}