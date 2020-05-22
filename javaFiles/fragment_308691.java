Set<String> tempSet = new HashSet<>();
    folders.forEach(folder -> tempSet.addAll(data.get(folder))); // flattening all the data elements into single set

    //Iterate over dataList where you are already maintaining order. If element exists, add it to allData
    dataList.forEach(item -> {
        if(tempSet.contains(item)){
            allData.add(item);
        }
    });