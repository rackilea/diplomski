List<Employee> uniqueEmployees = employees.stream()
            .collect(Collectors.groupingBy(Employee::getName,
                    Collectors.maxBy(Comparator.comparing(Employee::getAge))))
        .values()
        .stream()
        .map(Optional::get)
        .collect(Collectors.toList());