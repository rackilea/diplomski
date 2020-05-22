private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String execute() throws Exception {
    Map<String, Object> context = ActionContext.getContext().getValueStack().getContext();
    Object myToken = context.get("token");
    if (myToken == null) {
        myToken = TokenHelper.setToken("token");
        context.put("token", myToken);
    }
    token = myToken.toString();
    return SUCCESS;
  }