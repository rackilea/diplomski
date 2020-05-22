@Test
public void send() {   
    // making some data...
    parallelSender.send(someData);

   // Define the captor for class
    ArgumentCaptor<SenderTask> captor =
        ArgumentCaptor.forClass(SenderTask.class);

    // Capture input while verifying
    verify(parallelSender).doSend(captor.capture());

    // Assert 
    SomeTask result = captor.getValue();
    // assertions on result
}