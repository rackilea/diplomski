class LoginBeanResponse {
  @Nullable private final LoginBean loginBean;
  @Nullable private final ErrorMessage errorMessage;

  LoginBeanResponse(@Nullable LoginBean loginBean, @Nullable ErrorMessage errorMessage) {
    this.loginBean = loginBean;
    this.errorMessage = errorMessage;
  }
  // Add getters and whatever you need
}