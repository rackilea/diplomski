List<Function<? super Data, ? extends Comparable>> extractors = new ArrayList<>();
extractors.add(Data::getA);
extractors.add(Data::getB);

Comparator<Data> test = parseKeysAscending(extractors);

List<Data> data = new ArrayList<>(Arrays.asList(
    new Data(1, "z"),
    new Data(2, "b"),
    new Data(1, "a")));

System.out.println(data); // [[1, 'z'], [2, 'b'], [1, 'a']]

data.sort(test);

System.out.println(data); // [[1, 'a'], [1, 'z'], [2, 'b']]