public long findLocationId(String locationName) throws SystemException
    {

        if(locationName == null) { //Here we cover fist issue. 
            throw new IllegalArgumentException("THe locationName must not be null");
        }

        Collection<Location> locationList = getLocationList(); //The location can be read from another method so we are not binded to field.

        if(locationList == null) {
            throw new IllegalStateException("THe location list was not initialized"); 
        }

        for(Location location : locationList) {

            if(locationName.equalsIgnoreCase(location.getLocationName())) {
                return location.getLocationId(); //We exit from the method.
            }

        }

        throw new SystemException("Could not found location for name:" + locationName); 

    }