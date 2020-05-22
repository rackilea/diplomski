for(Location location : locationList) {

            if(locationName.equalsIgnoreCase(location.getLocationName())) {
                locId = location.getLocationId();
                break;
            }

        }