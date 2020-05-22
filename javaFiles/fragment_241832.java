List<String> students = new ArrayList();

    students.add("alice");
    students.add("jack");
    students.add("john");

    students.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println);