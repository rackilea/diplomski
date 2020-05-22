ArrayList<Student> studentList = new ArrayList<Student>();  

Student s1 = new Student(x, y, z);
Student s2 = new Student(a, b, c);  

studentList.add(s1);
studentList.add(s2);

Student s3 = new Student(x, y, z); //object to search

if(studentList.contains(s3)) {
    System.out.println(s3.toString()); //print object if object exists;
} // check if `studentList` contains `student3` with city `y`.It will internally call your equals method to compare items in list.