for (Object[] trials: trialSpecs) { 
    Object[] result= (Object[]) trials; 
    //Check to see if the key is already in the map:
    if(!multiValueMap.containsKey((Integer) result[0]){
        multiValueMap.put((Integer) result[0], new ArrayList()); 
    }
    multiValueMap.get(result[0]).add((Integer)result[1]); 
}