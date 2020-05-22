ArrayList<ZipCodeLocation> riZips = new ArrayList<ZipCodeLocation>();
//allZips is an array of all your ZipCodeLocations
for(int i = 0; i < allZips.length; i++){
    if(allZips[i].getState() == "RI")
        riZips.add(allZips[i]);
}