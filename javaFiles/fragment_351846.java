private static int getShortestTour() {
    return Winner.tdfWinnders
                 .stream()
                 .mapToInt(Winner::getLengthKm)
                 .min()
                 .orElse(Integer.MIN_VALUE);
}