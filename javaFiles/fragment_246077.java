private String myQuestionq1;
  private String myQuestionq2;

  public String getMyQuestionq1() {
    return myQuestionq1;
  }

  public void setMyQuestionq1(String myQuestionq1) {
    this.myQuestionq1 = myQuestionq1;
  }

  public String getMyQuestionq2() {
    return myQuestionq2;
  }

  public void setMyQuestionq2(String myQuestionq2) {
    this.myQuestionq2 = myQuestionq2;
  }

  @Action(value="save", results = {
    @Result(name="input", location = "/default.jsp"),
    @Result(name="back", type="redirect", location = "/")

  },interceptorRefs = @InterceptorRef(value="defaultStack", params = {"validation.validateAnnotatedMethodOnly", "true"}))
  @Validations(requiredFields = {
      @RequiredFieldValidator(type = ValidatorType.FIELD, fieldName = "myQuestionq1", message = "You must enter a value for field myQuestionq1."),
      @RequiredFieldValidator(type = ValidatorType.FIELD, fieldName = "myQuestionq2", message = "You must enter a value for field myQuestionq2.")
  })
  public String save() throws SQLException {