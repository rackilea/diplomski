public class Student {
  private ArrayList<Integer> grades;
  private String fName;
  private String lName;

  public Student(String inputLine) {
    grades = new ArrayList<>();
    String[] lineSplit = inputLine.split(" ");
    fName = lineSplit[0];
    lName = lineSplit[1];
    for (int i = 2; i < lineSplit.length; i++) {
      grades.add(Integer.parseInt(lineSplit[i]));
    }
  }

  private double computeAvg() {
    double sum = 0;
    for (Integer grade : grades) {
      sum = sum + grade;
    }
    return sum / grades.count();
  }

  @Override
  public String toString() {
    return "Name: " + fName + " " + lName + " Quiz Avg: " + computeAvg();
  }
}

private static final int NAMELIMIT = 5;

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    for (int i = 0; i < NAMELIMIT; i++) {
        String line = in.nextLine();
        Student s = new Student(line);
        System.out.println(s);
    }
}