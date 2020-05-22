List<String> list = Arrays.asList("a","b","c","d","e","f","g","h","i","j");

int pageSize = 3;

IntStream.range(0, (list.size() + pageSize - 1) / pageSize)
        .mapToObj(i -> list.subList(i * pageSize, Math.min(pageSize * (i + 1), list.size())))
        .forEach(System.out::println);