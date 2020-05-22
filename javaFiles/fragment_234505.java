// correct default state of a school:
private List<Students> associatedStudents = new ArrayList<>();

...

School school = new School("GeorgiaTech", ....);
session.save(school);
Student student = new Student("LazyStudent", ....);
session.save(student);
// now associate the student with the school:
school.getAssociatedStudents().add(student);

// done. Hibernate will insert the row in the association table for you.