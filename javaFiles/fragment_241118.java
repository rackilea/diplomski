private static <T> List<T> getFeeds(String url, WeatherDataFactory<T> factory) {
    ...
    if(nl != null && nl.getLength() > 0) {
        for(int i =0 ; i<nl.getLength() ; i++) {
            list.add(factory.parse(nl));
        }
    }
}