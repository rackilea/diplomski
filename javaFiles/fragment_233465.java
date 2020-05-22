public static void main(String[] args) {
  ObjectMapper mapper = new ObjectMapper();
  File file = new File("question.json");

  try {
    Questions question = mapper.readValue(file, Questions.class); // was Question
    System.out.println("category.getCategory() = " + question.getQuestions().get(0).getCategory()); // corrected after changing to Questions
  } catch (IOException e) {
    e.printStackTrace();
  }
}