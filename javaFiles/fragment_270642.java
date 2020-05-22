public class Question {
   private String question;
   private String correctAnswer;
   private List<String> wrongAnswers = new ArrayList<>();

   public Question(String question, String correctAnswer) {
      this.question = question;
      this.correctAnswer = correctAnswer;
   }

   public void addWrongAnswer(String wrongAnswer) {
      wrongAnswers.add(wrongAnswer);
   }

   public boolean testAnswer(String possibleAnswer) {
      return correctAnswer.equalsIgnoreCase(possibleAnswer);
   }

   public List<String> getAllRandomAnswers() {
      List<String> allAnswers = new ArrayList<>(wrongAnswers);
      allAnswers.add(correctAnswer);
      Collections.shuffle(allAnswers);
      return allAnswers;
   }

   public String getQuestion() {
      return question;
   }

   public String getCorrectAnswer() {
      return correctAnswer;
   }

   // toString, equals and hashCode need to be done too
}