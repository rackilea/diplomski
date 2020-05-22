@Test
public class UserAuthenticationTest { 
     // Given 
     UserAuthentication userAuthentication = new UserAuthentication(); 
     AuthenticationWebService mockedAuthenticationWebService = mock(AuthenticationWebService.class)

     String username = "aUsername" , password = "aPassword";
     when(mockedAuthenticationWebService.authenticate(username, password).thenReturn(true); // but you could return false here too if your test needed it

     userAuthentication.set(mockedAuthenticationWebService); 

     // When  
     boolean yourStubbedReturnValue = userAuthentication.authenticate(username, password); 

     //Then 
    verify(mockedAuthenticationWebService).authenticateUser(username, password); 
    assertThat(yourStubbedReturnValue, is(true));
}