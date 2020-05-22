if (a >= students.length) {
  int newSize = 1 + students.length; 
  Student[] newData = new Student[newSize];         
  System.arraycopy(students, 0, newData, 0, students.length);         
  students = newData;       
  // students[a] == null
}