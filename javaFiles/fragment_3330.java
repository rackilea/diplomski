Capture<A> capture = EasyMock.newCapture();
expect(mockRemoteService.someMethod(capture)).andReturn(whatever);
...

A a = capture.getValue();
// now check that a is OK.