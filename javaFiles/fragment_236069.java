List<List<String>> values = list.stream()
                .sorted()
                .collect(groupingBy(String::length))
                .values()
                .stream()
                .collect(toList());