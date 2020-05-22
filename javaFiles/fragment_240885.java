public class QuestionChangeHandler<T> implements ValueChangeHandler<T>{

  private String source;

  private Map<String, Integer> counter;

  public QuestionChangeHandler(String source, Map<String, Integer> counter) {
    super();
    this.source = source;
    this.counter = counter;
  }



  @Override
  public void onValueChange(ValueChangeEvent<T> event) {
    T value = event.getValue();
    if (value == null) {
      counter.put(source, Integer.valueOf(0));
    } else {
      counter.put(source, Integer.valueOf(1));
    }
  }


  /**
   * @return the source
   */
  public String getSource() {
    return source;
  }

}