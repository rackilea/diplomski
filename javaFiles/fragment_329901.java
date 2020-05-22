public Map<String, Set<String>> parseApiEntriesIntoMap(List<Restaurant> restaurants) {
    Map<String, Set<String>> restaurantListByNeighborhood = new HashMap<>();
    for (Restaurant restaurant : restaurants) {
        restaurantListByNeighborhood.merge(restaurant.getNeighborhood(),
                new HashSet<>(restaurant.getRestaurantList()),
                (strings, strings2) -> {
                    strings.addAll(strings2);
                    return strings;
                });
    }
    return restaurantListByNeighborhood;
}