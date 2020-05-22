public static final int EARTH_RADIUS = 3959; // Move constants out of methods

public ZipCode findZip(int zip){
    for(ZipCode zipCode : myZips){
        if(zipCode.getZipCode() == zip){
            return zipCode;
        }
    }
    return null;
}

public int distance(int zip1, int zip2){
    // save these references so you can use them later
    ZipCode z1 = findZip(zip1);
    ZipCode z2 = findZip(zip2);

    if(z1 != null && z2 != null) {
        double lat1  = Math.toRadians(z1.getLatitude());
        double long1 = Math.toRadians(z1.getLongitude());
        double lat2  = Math.toRadians(z2.getLatitude());
        double long2 = Math.toRadians(z2.getLongitude());

        double p1 = Math.cos(lat1) * Math.cos(long1) * Math.cos(lat2) * Math.cos(long2);       
        double p2 = Math.cos(lat1) * Math.sin(long1) * Math.cos(lat2) * Math.sin(long2);         
        double p3 = Math.sin(lat1) * Math.sin(lat2);         

        double distance = Math.acos(p1+p2+p3) * EARTH_RADIUS;
        return (int)Math.round(distance);
    }
    else return -1;
}

public ArrayList <ZipCode> withinRadius(int pZip, int pRadius){
    ZipCode zip = findZip(pZip); // save this reference to calculate the distances

    ArrayList<ZipCode> zips = new ArrayList<ZipCode> ();
    if (zip != null) {
        for (int i = 0; i < myZips.size(); i++) {
            ZipCode z = myZips.get(i); // or use a for-each loop like in findZip
            if (distance(zip.getZipCode(), z.getZipCode()) <= pRadius) {
                zips.add(z);
            }
        }
    }
    return zips;
}