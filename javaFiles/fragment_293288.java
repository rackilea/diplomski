public static void main(String[] args) {
        String data = "USA     |  NY   | Brooklyn    | 11210\n" +
                "USA     |  NY   | Brooklyn    | 11211\n" +
                "USA     |  NY   | Brooklyn    | 11212\n" +
                "USA     |  NY   | Brooklyn    | 11213\n" +
                "USA     |  NY   | Bronx       | 10450\n" +
                "USA     |  NY   | Bronx       | 10451\n" +
                "USA     |  NY   | Bronx       | 10452\n" +
                "USA     |  NJ   | Jersey City | 07310\n" +
                "USA     |  NJ   | Jersey City | 07311\n" +
                "Canada  |  ON   | Keswick     | L4P 4K3";
        List<String[]> lines = Arrays.stream(data.split("\n"))
                .map(line -> line.split("\\|"))
                .map(lineParts -> Arrays.stream(lineParts).map(String::trim).toArray(String[]::new))
                .collect(Collectors.toList());

        Map<String, Map<String, Map<String, List<String[]>>>> nestedMap = lines.stream().collect(Collectors.groupingBy(
                line -> line[0],
                Collectors.groupingBy(
                        line -> line[1],
                        Collectors.groupingBy(line -> line[2])
                )
        ));

        Jsonb jsonb = JsonbBuilder.create();
        String json = jsonb.toJson(nestedMap);
        System.out.println(json);
    }