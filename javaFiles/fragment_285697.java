all.forEach(System.out::println);

all.stream().map(l -> l.stream()
        .map(Row::getValue)
        .reduce(Integer::sum)
        .get()
)
.forEach(System.out::println);