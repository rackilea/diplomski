public static void main(String[] args) {

    List<Data> objects = Arrays.asList(new Data(1, 3, 1001), new Data(2, 2, 1001), new Data(3, 1, 1001),
            new Data(4, 1, 1002), new Data(5, 1, 1003));

    Map<Integer, Data> filtered = objects.stream().collect(Collectors.groupingBy(Data::getRootId, Collectors
            .collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Data::getVersion)), Optional::get)));

    System.out.println(filtered.values());
}

static class Data {
    int id;
    int version;
    int rootId;

    //getter,setter & constructors
    //toString
}