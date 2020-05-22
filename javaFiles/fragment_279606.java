public synchronized URL getImageURL() throws IllegalStateException {
    checkVisible();
    if (imageURL == null) {
        try {
            String fileName = _getImageFileName(splashPtr);
            String jarName = _getImageJarName(splashPtr);
            if (fileName != null) {
                if (jarName != null) {
                    imageURL = new URL("jar:"+(new File(jarName).toURL().toString())+"!/"+fileName);
                } else {
                    imageURL = new File(fileName).toURL();
                }
            }
        }
        catch(java.net.MalformedURLException e) {
            // we'll just return null in this case
        }
    }
    return imageURL;
}