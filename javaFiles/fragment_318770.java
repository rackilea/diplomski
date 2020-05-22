// Uses string array from input file to create new student object
public static void processStudentData(String[] a) {

  System.out.println("Running Test 2a:");
  if (a[1].equals("ADD")) {
     Student student2 = new Student(a[2], a[3], a[4], a[5]);
  }

} // End processStudentData