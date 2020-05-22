public class Questions {

  @JsonProperty("Questions")
  private List<Question> questions;

  @JsonCreator
  public Questions(@JsonProperty("Questions") List<Question> questions) { // was missing @JsonProperty
    this.questions = questions;
  }