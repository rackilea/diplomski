public int getAvgDelay() {
    return trainStop.stream()
            .flatMapToInt(a -> a.getDelays().stream())
            .average().stream()
            .mapToLong(Math::round).mapToInt(i -> (int) i)
            .findFirst().orElse(-1);
}