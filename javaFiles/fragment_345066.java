for (T t : myList) {
    if (t instanceof Student) {
      Student student = (Student) t;
      student.getGpa();
    } else if (t instanceof Food) {
      ...
    }
 }