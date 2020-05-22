@Override
protected URLConnection openConnection(URL u) throws IOException {
    // 1. Use Apache HTTPClient or something else to grab the url
    // 2. Read the resultCode and report if it's a 404
    // 3. Return an object that subclasses URLConnection
}