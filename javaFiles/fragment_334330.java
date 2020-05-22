MyService spyWs = Mockito.spy(MyWebService.class);

doReturn(true).when(spyWs).sendCustomEmail(any(), any(), any());

MyService::sendEmail(spyWs);

verify(spyWs, once())
   .sendCustomEmail(
      eq("me@example.com"), 
      eq("Subject"), 
      eq("here should be another body and test shou")
);

// assert that sendMail returned true;