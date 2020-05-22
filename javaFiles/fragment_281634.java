Iterator<Location> iterator = locationList.iterator();

        while(iterator.hasNext() && Long.MIN_VALUE != locId) {

            Location location = iterator.next();

            if(locationName.equalsIgnoreCase(location.getLocationName())) {
                locId = location.getLocationId(); // This will change the locId, so second condition will be no longer true and loop will end.
            }

        }