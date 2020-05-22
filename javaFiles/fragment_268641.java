public static void main(String[] args) throws IOException, TransformerException {
    List<Data> list = Arrays.asList( //
            new Data("28696", "2", "11/15/19 17:57"), //
            new Data("28696", "1", "11/15/19 17:56"), //
            new Data("00972", "2", "11/15/19 17:55"), //
            new Data("28696", "3", "11/15/19 17:54"), //
            new Data("00972", "1", "11/15/19 17:53"));

    Comparator<Data> sortByTimestamp = Comparator.comparing(Data::getTimestamp).reversed();
    Comparator<Data> sortByOccurrence = Comparator.comparing(Data::getOccurrence).reversed();

    // LinkedHashMap keeps the insertion order
    Collector<Data, ?, LinkedHashMap<String, List<Data>>> groupByIdKeepInsertOrder
            = Collectors.groupingBy(Data::getId, LinkedHashMap::new, Collectors.toList());

    List<Data> result = list.stream()
            .sorted(sortByTimestamp) // sort all data by timestamp, if it's already sorted by timestamp you can skip this
            .collect(groupByIdKeepInsertOrder) // group them by id keeping the timestamp order
            .values().stream() // stream the lists of data grouped together
            .peek(l -> l.sort(sortByOccurrence)) // sort each list of data by occurrence
            .flatMap(Collection::stream) // flatten the lists into a single stream
            .collect(Collectors.toList()); // collect all Data into a single list

    System.out.println(result);
    // [[28696, 3, 11/15/19 17:54],
    //  [28696, 2, 11/15/19 17:57],
    //  [28696, 1, 11/15/19 17:56],
    //  [00972, 2, 11/15/19 17:55],
    //  [00972, 1, 11/15/19 17:53]]
}