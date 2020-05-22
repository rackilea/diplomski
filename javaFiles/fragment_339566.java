fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            location?.let { it: Location ->
                // Logic to handle location object
            } ?: kotlin.run {
                // Handle Null case or Request periodic location update https://developer.android.com/training/location/receive-location-updates
            }
        }