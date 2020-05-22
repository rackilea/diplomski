public static boolean hasDuplicates() {
        List<Integer> forbiddenValues = Arrays.asList(1, 2, 3);

        List<MyPojo> pojoList = Arrays.asList(new MyPojo(0), new MyPojo(2),
                new MyPojo(2), new MyPojo(3), new MyPojo(3), new MyPojo(4));


        long count = pojoList.stream()
                .filter(pojo -> forbiddenValues.contains(pojo.getValue()))
                .map(MyPojo::getValue)
                .collect(Collectors.groupingBy(value -> value))
                .values()
                .stream()
                .filter(values -> values.size() > 1)
                .count();

        return count > 1;
    }