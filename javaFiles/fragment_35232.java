Map<String,List<Object>> timeTableSortedByDestination = new HashMap<String,List<Object>>();
Map<Object,List<String>> timeTableSortedByDepartTime = new HashMap<Object,List<String>>();
List<String> temp;    

// dump all of the objects into the new map
for(String s : timeTableSortedByDestination.keySet()){
    for(Object o : timeTableSortedByDestination.get(s)){
        timeTableSortedByDepartTime.put(o, new ArrayList<String>());
    }
}

//iterating through each list in the original map
for(Object o : timeTableSortedByDepartTime.keySet()){
    for(String s : timeTableSortedByDestination.keySet()){
        // if the object was in that list
        if(timeTableSortedByDestination.get(s).contains(o)){
            temp = timeTableSortedByDepartTime.get(o);
            temp.add(s);
            // add the corresponding string to the list in the new map
            timeTableSortedByDepartTime.put(o, temp);
        }
    }
}