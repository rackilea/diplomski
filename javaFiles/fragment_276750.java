class University {
  private Set<Major> majors;
}

class Major {
  private Set<Student> students;
}

class Main {
  // true if the path is valid, else false
  public boolean query(University university, Major major, Student student) {
    return university.getMajors().contains(major) &&
      major.getStudents().contains(student);
  }
}