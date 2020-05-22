Set<String> tempSet = new HashSet<>();
    // flattening all the data elements into single set
    for(String folder:folders) {
        tempSet.addAll(data.get(folder));
    }

    //Iterate over dataList where you are already maintaining order. If element exists, add it to allData
    for(String item:dataList){
        if(tempSet.contains(item)){
            allData.add(item);
        }
    }