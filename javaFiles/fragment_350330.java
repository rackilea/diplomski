static List<Integer> storeStudentIds(Path file) throws IOException {
  Gson gson = new Gson();
  try (Reader r = Files.newBufferedReader(file)) {
    StudentGroup group = gson.fromJson(r, StudentGroup.class);
    return group.student.stream().map(s -> s.id).collect(Collectors.toList());
  }
}

private static final class StudentGroup {

  private List<Student> student;
  private int cost;
  private int month;
}

private static final class Student {

  String name;
  int id;
}