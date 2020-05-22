public static void main(String... aArgs) {

    List<String> domainDailyData1 = Arrays.asList(new String[]{ "gmail.com", "172.11.0.89", "1", "gmail.com", "172.11.0.89", "60", "gmail.com", "192.168.0.66", "13"});

    Stream
        .iterate(1, i -> i + 3)
        .limit(domainDailyData1.size() / 3)
        .collect(Collectors.toMap(
                i -> domainDailyData1.get(i),
                i -> {
                    try {
                        return Integer.parseInt(domainDailyData1.get(i + 1));
                    }
                    catch (NumberFormatException e) {
                        return 0;
                    }
                },
                Integer::sum))
        .entrySet()
        .stream()
        .forEach(System.out::println);
}