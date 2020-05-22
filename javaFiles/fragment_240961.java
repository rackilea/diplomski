@Test
public void successfulLoginReturnsExpectedResponseCode() {
   String responseCode = login(username, password)

   assertThat(responseCode, is(equalTo("SUCCESSFUL_LOGIN")));
}