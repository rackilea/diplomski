studentList.stream()
           .collect(toMap(Student::getFavouriteColor, s -> 1, Math::addExact))
           .entrySet()
           .stream()
           .sorted(Map.Entry.comparingByValue())
           .forEachOrdered(e -> System.out.println(e.getKey() + ":" + e.getValue()));