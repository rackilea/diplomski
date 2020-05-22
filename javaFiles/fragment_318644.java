public static void main(String[] args) {
    Map<Integer, Map<Integer, List<Integer>>> dates =
        new HashMap<Integer, Map<Integer, List<Integer>>>() {{
            put(1999, new HashMap<Integer, List<Integer>>() {{
                put(3, Arrays.asList(23, 24, 25));
                put(4, Arrays.asList(1, 2, 3));
            }});
            put(2001, new HashMap<Integer, List<Integer>>() {{
                    put(11, Arrays.asList(12, 13, 14));
                    put(12, Arrays.asList(25, 26, 27));
            }});
        }};

    dates.entrySet().stream().flatMap(year ->
        year.getValue().entrySet().stream().flatMap(month ->
            month.getValue().stream()
                .map(day -> day + "," + month.getKey() + "," + year.getKey())))
        .forEach(System.out::println);
}