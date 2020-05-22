Person maxValuePerson = people.parallelStream()
            .max(Comparator.comparing(p -> ((Person) p).getMyValue()))
            .get();
    Person minValuePerson = people.parallelStream()
            .min(Comparator.comparing(p -> ((Person) p).getMyValue()))
            .get();