List<String> lista = List.of(
            "Sevilla reserves himself to Apoel … sportyou 10/10/2019",
            "I am new here 20/8/2019",
            "A painting by Banksy … 19/10/2019");
    List<String> sortedList = lista.stream()
            .map(s -> new Object() {
                String theString = s;
                LocalDate date = extractDate(s);
            })
            .sorted(Comparator.comparing(obj -> obj.date))
            .map(obj -> obj.theString)
            .collect(Collectors.toList());
    sortedList.forEach(System.out::println);