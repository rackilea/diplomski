List<String> list = Arrays.asList("hello","world","Hola","Mundo","hello", "world","Hola","Mundo","mundo","Hello","Hola","mundo","Mundo");

Map<String, Long> ocurrences = list
        .stream()
        .map(String::toLowerCase) // make case insensitive
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

System.out.println(ocurrences);