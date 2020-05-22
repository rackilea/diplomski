List<ZipCode> myZips = // create all ZipCode's somehow

public ZipCode findZip(int zip){

    //look at all zips
    for(ZipCode zipCode : myZips){

        //if we find one that matches the one we want, return it
        if(zipCode.getZipCode() == zip){
            return zipCode;
        }
    }

    // we checked all our zip's and couldn't find this one
    return null;
}