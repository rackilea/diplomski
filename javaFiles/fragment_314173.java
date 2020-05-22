List<Data> list = new LinkedList<>();
list.add(new Data(1, "00022954", 41.418));
list.add(new Data(2, "00022951", 1.0));
list.add(new Data(3, "00022953", 41.512));
list.add(new Data(3, "00022945", 41.575));
list.add(new Data(3, "00022945", 41.621));

// shuffle to test sorting
Collections.shuffle(list);

// sort the data
Collections.sort(list, 
    Comparator.comparing(Data::getFirst)
        .thenComparing(Data::getSecond)
        .thenComparing(Data::getThird));

// output the data
list.forEach(System.out::println);