advancedModel.addOverlay(new Marker
(new
    LatLng(user.getLatitude(), user.getLongitude()), // LatLgn latitude and longitude
    user.getName(), // String title
    user.getPhoto(), //Object data
    iconName, // String icon
    user.getAddress() + ", " + user.getNumber() + " - " + user.getNeighborhood() // String shadow)
);