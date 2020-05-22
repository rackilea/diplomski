@Test
public void testEmailPatroonFout() throws Exception{
    //Verkeerde emailpatronen
    List<String> emails = new ArrayList<>();
    emails.add(".username@yahoo.com");

    TestMethod<AccountService, String> method
        = method(AccountService.class, "checkEmailPatroon", String.class);

    assertThatThrownBy(() -> {
        for(String email : emails){
            method.invoke(AccountService, email);
        }
    }).isInstanceOf(ApplicationException.class)
      .hasMessage(ApplicationExceptionType.ONGELDIGE_EMAIL.getMsg());
}