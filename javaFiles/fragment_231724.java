public class QuestionAnswers {
  public static void main(String[] args) {
    HashMap<String, String> questionSets = new HashMap<String, String>();
    questionSets.put("Question1", "Answer1");
    questionSets.put("Question2", "Answer2");
    questionSets.put("Question3", "Answer3");
    questionSets.put("Question4", "Answer4");
    questionSets.put("Question5", "Answer5");

    List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(questionSets.entrySet());

    System.out.println("************ Questions ************");
    Collections.shuffle(list);
    for (Map.Entry<String, String> entry : list) {
        System.out.println(entry.getKey());
        // Here entry.getKey() is Question and if user enters the correct answer 
        // match that answer with like -> "user_answer".equals(entry.getValue());
    }
  }
}