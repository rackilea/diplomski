fusedLocationClient.getLastLocation().addOnSuccessListener(requireActivity(), location -> {
        if (location != null) {
            // Logic to handle location object
        } else {
            // Handle null case or Request periodic location update https://developer.android.com/training/location/receive-location-updates
        }
    });