if (!location.startsWith("http")) {
    String newLocation = url.getProtocol() + "://" + url.getHost();
    if (url.getPort() > 0) {
        newLocation += ":" + url.getPort();
    }
    if (location.startsWith("/")) {
        newLocation += location; 
    }
    else {
        if (!location.startsWith("/")) {
            location = "/" + location;
        }
        newLocation += url.getPath() + location;
    }
    location = newLocation;
}
url = new URL(location);