abstract class AbstractMcq {
   // common properties and functions
}

class Mcq extends AbstractMcq {
    @DBRef public List<Question> questions;
}

class McqInstance extends AbstractMcq {
  public List<QuestionAnswers> questions;
}