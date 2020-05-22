// setup: data
    ISomething fooSomething = ISomethingImpl(5, "bar"); 

    // setup: expectations
    Capture<ISomething> capturedISomething = new Capture<ISomething>();
    mockCollaborator.setSomething(capture(capturedISomething));

    // exercise
    replay(mockCollaborator);
    sut.dooWhateverThatInvokesTheCollaboratorSetter(fooSomething);

    // verify
    verify(mockCollaborator);
    assertEquals(5, capturedISomething.getValue().getValue1());
    assertEquals("bar", capturedISomething.getValue().getValue2());