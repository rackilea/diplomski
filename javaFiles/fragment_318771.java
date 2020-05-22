// Uses string array from input file to create new student object
public static Student processStudentData(String[] a) {

  System.out.println("Running Test 2a:");
  if (a[1].equals("ADD")) {
     return new Student(a[2], a[3], a[4], a[5]);
  }

  return null;

} // End processStudentData