Bundle bundle = getMyBundle();
for (String key : bundle.keySet()) {
    String value = bundle.get(key);
    try {
        URL url = new URL(value);
        // no exception thrown! this is a valid URL
        // do something with ulr
    } catch (MalformedURLException exception) {
        // this item is no URL
    }
}