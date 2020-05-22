public Student search( String studentName){

    foreach(Student s : allStudents)
    if(s.getName().equals(studentName){

// you can return this student object or print his other details 
// System.out.println(s.getAddress()); etc
       return s;
    }
    return null;
    }
    }