for(File temp : filteredDirectoryList) {

    splitArr = temp.getName().split("-");

    //HERE IS WHERE YOU CREATE THE NEW LIST IF THE KEY DOESN'T HAVE IT
    if(!listOfDirectories.containsKey(splitArr[1])) {
        listOfDirectories.put(splitArr[1], new ArrayList<>());
    } 

    listOfDirectories.get(splitArr[1]).add(splitArr[0]);
}