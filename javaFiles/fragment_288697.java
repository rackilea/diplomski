private static ArrayList<students> studentArray = new ArrayList<students>();

// Inside the constructor or some method called before you access studentArray:
studentArray.add(stu1);
studentArray.add(stu2);
//...

// or, more concisely, since you're not using the temporary `students` variables:
studentArray.add(new students(65435, "Bob", "Ted"));
studentArray.add(new students(45546, "Guy", "Sid"));
//...