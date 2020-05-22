public Map<String, Set<String>> parseApiEntriesIntoMap(List<Restaurant> restaurants) {
    // read below about the null check
    return restaurants.stream()
            .collect(Collectors.toMap(Restaurant::getNeighborhood,
                    r -> new HashSet<>(r.getRestaurantList()), (set1, set2) -> {
                        set1.addAll(set2);
                        return set1;
                    }));
}