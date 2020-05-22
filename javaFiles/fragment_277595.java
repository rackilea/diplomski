import static java.util.stream.Collectors.*;

List<Foo> result = map.values()
    .stream()
    .map(
        foos -> new Foo(foos.stream()
                    .flatMap(foo -> foo.getBars().stream())
                    .collect(toList())))
    .collect(toList());