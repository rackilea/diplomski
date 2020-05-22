public class RegistrationBean {
  @Valid
  SecurityQuestion securityQuestion;
  String name;

  public SecurityQuestion getSecurityQuestion(){
        return securityQuestion;
  }
  public void setSecurityQuestion(SecurityQuestion q){
      this.securityQuestion = q;
  }    
  public SecurityQuestionType[] getSecurityQuestionOptions() {
    return SecurityQuestionType.values();
  }
}