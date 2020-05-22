public static findKeyForPtr(final Ptr searchPtr) {
    for (Map.Entry<Xyz, List<Ptr>> entry : map.entrySet()) {
        if (entry.getValue().contains(searchPtr)) {
            return entry.getKey();
        }
    }
}