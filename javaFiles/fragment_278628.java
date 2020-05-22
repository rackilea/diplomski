private PlaceName parseResult(GeocodingResult r) {

    PlaceName placeName = new PlaceName(); // simple POJO

    for (AddressComponent ac : r.addressComponents) {
        for (AddressComponentType acType : ac.types) {

            if (acType == AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1) {

                placeName.setStateName(ac.longName);

            } else if (acType == AddressComponentType.LOCALITY) {

                placeName.setCityName(ac.longName);

            } else if (acType == AddressComponentType.COUNTRY) {

                placeName.setCountry(ac.longName);
            }
        }

        if(/* your condition */){ // got required data
            break;
        }
    }

    return placeName;
}