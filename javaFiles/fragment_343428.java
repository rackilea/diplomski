int[] mas1 = {1,2,3,4,5};
String[] mas2 ={"a","b","c","d","e"};
String[] combined = IntStream.range(0, mas1.length)
        .boxed()
        .flatMap(i -> Stream.of(mas2[i], String.valueOf(mas1[i])))
        .toArray(String[]::new);