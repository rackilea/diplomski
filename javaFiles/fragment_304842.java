import java.util.Arrays;

class StudentAnswer {
    private int id;
    private String value;

    public StudentAnswer(int id, String ans) {
        this.id = id;
        this.value = ans;
    }

    public int getQuestionNumber() {
        return this.id;
    }

    public String toString() {
        return this.value;
    }
}

class Main {
  public static void main(String[] args) {
    StudentAnswer a0 = new StudentAnswer(0, "Foo");
    StudentAnswer a1 = new StudentAnswer(1, "Class");
    StudentAnswer a3 = new StudentAnswer(3, "Object");

    int totalQuestions = 4;
    StudentAnswer[] answers = new StudentAnswer[totalQuestions];
    answers[a0.getQuestionNumber()] = a0;
    answers[a1.getQuestionNumber()] = a1;
    answers[a3.getQuestionNumber()] = a3;

    System.out.println(Arrays.asList(answers));
  }
}