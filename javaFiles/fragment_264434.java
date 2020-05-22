public class Answer{ // The class

  private String answer; // internal variable only visible for the class

  public Answer(String answer){ // This is a constructor
    this.answer = answer; // Here we assign the String we gave this object to an internal variable
  }

  public void setAnswer(String answer){ // Setter
    this.answer = answer;
  }

  public String getAnswer(){ // Getter
    return answer;
  }
}