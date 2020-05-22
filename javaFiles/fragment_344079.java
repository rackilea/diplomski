public void testGoodLogin() throws Exception {
    WebConversation     conversation = new WebConversation();
    WebRequest  request = new GetMethodWebRequest( "http://www.meterware.com/servlet/TopSecret" );
    WebResponse response = conversation.getResponse( request );

    WebForm loginForm = response.getForms()[0];
    request = loginForm.getRequest();
    request.setParameter( "name", "master" );

    // "clicking the button" programatically
    response = conversation.getResponse( request );

    assertTrue( "Login not accepted", 
               response.getText().indexOf( "You made it!" ) != -1 );
    assertEquals( "Page title", "Top Secret", response.getTitle() );
}