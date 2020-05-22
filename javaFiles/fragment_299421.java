public String getState(Map<String, List<String>> stateCityMap, String city) throws CityNotFoundException {
    for (Map.Entry<String, List<String>> entry : stateCityMap.entrySet()) {
        if (entry.getValue().contains(city)) {
            return entry.getKey();
        }
    }

    throw new CityNotFoundException("City Not Found");
}