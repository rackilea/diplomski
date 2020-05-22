public void process() {
  final int SIZE = 10;
  String[] names = new String[SIZE];
  int[] marks = new int[SIZE];
  for(int i = 0; i < SIZE; i++) {
    names[i] = readStudentNameFromGUI();
    marks[i] = readStudentsMarkFromGUI();
  }
  double average = calculateAverage(marks);
}