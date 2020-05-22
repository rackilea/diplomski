List<Student> list = schoolsMap.entrySet().stream()
                .filter(e -> e.getKey().lastname
                        .equals("Holmes"))
                .map(Entry::getValue)
                .collect(Collectors.toList());


        list.forEach(System.out::println);