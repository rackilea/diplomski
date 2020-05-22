import static java.util.stream.Collectors.toList;

// ...

final List<String> urls = Arrays.asList("foorecap", "recapfoo", "bar", "baz");
final List<String> recaps = urls.stream()
                                .filter(url -> url.contains("recap"))
                                .collect(toList());