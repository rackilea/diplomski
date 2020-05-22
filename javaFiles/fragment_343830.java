Map<Integer, List<Integer>> segregateSamples(List<Integer> sampleBins, List<Integer> samples) {

    Map<Integer, List<Integer>> groupedSamples = samples.stream().collect(Collectors.groupingBy(x -> 10 * x / 10));

    return sampleBins.stream().collect(Collectors.toMap(Function.identity(), b -> 
            groupedSamples.getOrDefault(b, Collections.emptyList())));
}