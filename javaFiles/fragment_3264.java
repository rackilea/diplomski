private int getNextRow(List<Location> locations) {
    if (locations.isEmpty())
        return 0;
    return locations.stream().mapToInt(location -> location.row)
            .min().getAsInt();
}