List<List<List<String>>> collect = list
            .stream()
            .map(a -> a
                    .stream()
                    .map(b -> b
                            .stream()
                            .map(String::valueOf)
                            .collect(Collectors.toList()))
                    .collect(Collectors.toList()))
            .collect(Collectors.toList());