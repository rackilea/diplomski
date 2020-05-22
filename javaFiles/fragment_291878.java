public static void main(String[] args) {
    List<Student> students1 = Arrays.asList(
            new Student(LocalTime.parse("14:30:20"),"s1"),
            new Student(LocalTime.parse("14:30:12"),"s1"));

    List<Student> students2 = Arrays.asList(
            new Student(LocalTime.parse("14:30:13"),"s2"),
            new Student(LocalTime.parse("14:30:20"),"s2"));

    Map<LocalTime,List<Student>> groupByTime = Stream.concat(students1.stream(), students2.stream())
        .collect(Collectors.groupingBy(Student::getTime));


    for(Entry<LocalTime,List<Student>> entry : groupByTime.entrySet()) {
        System.out.println(entry.getKey());
        for(Student student : entry.getValue()) {
            System.out.println("\t"+student.getName());
        }
    }
}