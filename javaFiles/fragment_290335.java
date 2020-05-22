public static void main(String[] args) {
  String a [] = {"Ram", "Krishna", "Sam", "Tom"};

  // Keys: student names
  Map<String, Student> al = new HashMap<String, Student>();

  // Fill the Student's map
  for(int i = 0; i < a.length; i++){
    String name = a[i];
    al.put(name, new Student(name));
  }

  // Manipulate one student by name. If there is no entry for that name we get null.
  // So we better check for null before using it.
  Student student = al.get("Krishna");
  if(student != null) {
    student.setAge(24);
  }

  // Output the all students
  for(Student obj: al.values()){
    System.out.println("Name = "+ obj.getName() + " Age = " + obj.getAge());  
  }  
}