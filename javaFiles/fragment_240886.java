public class AnswersApp implements EntryPoint {

  private VerticalPanel mainPanel = new VerticalPanel();
  private Label answersLabel = new Label("Answers");
  private Label answerNumber = new Label("0");

  private ValueListBox<Boolean> question1 = new ValueListBox<Boolean>(new BooleanRenderer(), new BooleanKeyProvider());
  private ValueListBox<Boolean> question2 = new ValueListBox<Boolean>(new BooleanRenderer(), new BooleanKeyProvider());

  private ValueChangeHandler<Boolean> updateHandler;

  private HashMap<String, Integer> counter = new HashMap<String, Integer>();

  public void onModuleLoad() {
    initUpdateHandler();
    List<Boolean> values = new ArrayList<Boolean>();
    values.add(Boolean.TRUE);
    values.add(Boolean.FALSE);
    question1.setAcceptableValues(values);
    question2.setAcceptableValues(values);
    question1.addValueChangeHandler(new QuestionChangeHandler<Boolean>("q1", counter));
    question2.addValueChangeHandler(new QuestionChangeHandler<Boolean>("q2", counter));

    question1.addValueChangeHandler(updateHandler);
    question2.addValueChangeHandler(updateHandler);

    mainPanel.add(question1);
    mainPanel.add(question2);
    mainPanel.add(answersLabel);
    mainPanel.add(answerNumber);

    RootPanel.get().add(mainPanel);
  }


  private void initUpdateHandler() {
    updateHandler = new ValueChangeHandler<Boolean>() {

      @Override
      public void onValueChange(ValueChangeEvent<Boolean> event) {
        recalculateAnswers();

      }
    };

  }

  private void recalculateAnswers() {
    Set<String> keys = counter.keySet();
    int answers = 0;
    for (String key : keys) {
      Integer value = counter.get(key);
      if (value != null && value.intValue() == 1) {
        answers++;
      }
    }
    answerNumber.setText(Integer.toString(answers));
  }
}