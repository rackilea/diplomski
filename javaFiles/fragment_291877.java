public static void main(String[] args) {
    List<Student> students = Arrays.asList(
        new Student(LocalTime.parse("14:30:12"),"s1"),
        new Student(LocalTime.parse("14:30:12"),"s2"),
        new Student(LocalTime.parse("14:30:13"),"s3"));

    Map<LocalTime,List<Student>> groupByTime = students.stream()
        .collect(Collectors.groupingBy(Student::getTime));

    // print the grouped students to System.out
    for(Entry<LocalTime,List<Student>> entry : groupByTime.entrySet()) {
        System.out.println(entry.getKey());
        for(Student student : entry.getValue()) {
            System.out.println("\t"+student.getName());
        }
    }
}