private static final int REQUEST_PERMISSION_LOCATION = 255; // int should be between 0 and 255

    ...

    // When you need the permission, e.g. onCreate, OnClick etc.
    if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_PERMISSION_LOCATION);
    } else {
        // We have already permission to use the location
    }