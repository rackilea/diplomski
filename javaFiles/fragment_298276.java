if(addressList != null && addressList.size() > 0) {
    // location exists
    Address address = addressList.get(0);
    System.out.println(address);
    if(address.hasLatitude() && address.hasLongitude()){
        coordinates[0] = address.getLatitude();
        coordinates[1] = address.getLongitude();
        this.canGetCoordinates = true;
        this.isLocationValid = true;
        System.out.println(coordinates[0]);
        System.out.println(coordinates[1]);
    }
} else { 
    // location does not exist
}