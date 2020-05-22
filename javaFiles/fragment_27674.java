public void displayInformation(int inNum) {
    String id = "audio"; 

    // for inNum < 9, we need to add 0, so for example when you pass 0
    // id will be 01, not 1
    if (inNum < 9) then id += "0";

    //based on your code, 0 - audio01, 1 - audio02 etc, so add 1
    id += (inNum + 1); 

    // call getIdentifier with string containing resource name, which are in your raw folder
    // and in your package
    int k = getResources().getIdentifier(id, "raw", "your.package.name.here");

    //k now contains an id of your resource, so do whatever you want with it
}