myMap.forEach((key, value) -> {
    final CustomList param2 = value.getParam2();
    IntStream.range(0, param2.getSize()).forEach(
        i -> System.out.println(key+"-"+value.getParam1()+"-"+param2.get(i))
    )
});