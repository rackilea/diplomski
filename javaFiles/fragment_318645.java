dates.entrySet().stream().flatMap(year ->
        year.getValue().entrySet().stream().flatMap(month ->
            month.getValue().stream()
                .map(day -> Arrays.asList(year.getKey(), month.getKey(), day))))
        .sorted(Comparator.comparing(l -> l.get(0)*10000 + l.get(1)*100 + l.get(2)))
        .forEach(System.out::println);