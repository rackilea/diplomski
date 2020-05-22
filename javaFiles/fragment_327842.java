public void recurseLocation(String url) {

    URL url = new URL(location);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setInstanceFollowRedirects(false);
    connection.connect();
    String newLocation = connection.getHeaderField("Location");

    if (newLocation != null) {
        newLocation = recurseLocation(newLocation);
    } else {
        newLocation = location;
    }

    return newLocation;
}