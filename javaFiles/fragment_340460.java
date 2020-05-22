class Student {
  private final List<Double> grades = new ArrayList<>(10);
  private final String name;
  // Constructor, getters & setters omitted. 
}

// ..
Student student = // ...
for (int i=0; i<10; i++) {
    System.out.println("Please enter the "+(i+1)+"th grade:");
    student.getGrades().add(scanner.nextDouble());
}
// ..
Student student = // ...
student.getGrades().forEach(System.out::println);