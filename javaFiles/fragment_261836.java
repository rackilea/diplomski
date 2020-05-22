import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

@Test
    public void testExceptionCaughtWhenThrownByRestTemplate(){
        PowerMockito.mockStatic(OkHttp3TemplateUtil.class);
        Doc doc = new Doc.docBuilder().setSomething("");

                when(something.thatReturnsOAuth2RestTemplate(any(Props.class))).thenReturn(restTemplate);
        when(restTemplate.postForEntity(anyString(), any(), eq(String.class))).thenReturn(response);
}