import static java.util.Arrays.asList;

...

Student student_andy = new Student(
  1001,
  "Andy",
  asList(new Friend(1002, "Bob")),
  asList(new Schedule(1, "Yoga practice"))
)