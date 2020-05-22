private int getNextPos(int currentPosition, List<Location> locations) {
    if (locations.isEmpty())
        return 0;
    OptionalInt min = locations.stream().filter(location -> location.position > currentPosition)
            .mapToInt(location -> location.position)
            .min(); 
    return min.isPresent() ? min.getAsInt() : 0;
}