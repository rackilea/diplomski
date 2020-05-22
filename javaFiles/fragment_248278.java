List<Classroom> classrooms = dataSource.fetchClassroomsById(classroomIds);
List<Student> students = dataSource.fetchStudentsById(classroomIds);
List<Teacher> teachers = dataSource.fetchTeachersById(classroomIds);

Map<Integer, List<Student>> classroomIdToStudent = students.stream()
    .collect(Collectors.groupingBy(Student::getClassroomId));

Map<Integer, List<Teacher>> classroomIdToTeacher = teachers.stream()
    .collect(Collectors.groupingBy(Teacher::getClassroomId));

List<Foo> foos = classrooms.stream().map(c -> new Foo(c.getId(), c.getName(),
    classroomIdToStudent.get(c.getId()), classroomIdToTeacher.get(c.getId()))).collect(Collectors.toList());