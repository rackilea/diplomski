public long findLocationId(String locationName) throws SystemException
    {

        if(locationName == null) { //Here we cover first issue. 
            throw new IllegalArgumentException("THe locationName must not be null");
        }

        long locId = Long.MIN_VALUE; //We declare a default value that will be returned if none match found. 

        Collection<Location> locationList = getLocationList(); //The location can be read from another method so we are not binded to field.

        if(locationList == null || locationList.isEmpty()) {
            return locId; // Or throw an exception about invalid state.
        }


        //Place for the logic


        return locId;

    }