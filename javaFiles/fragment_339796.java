RequestDispatcher dispatcherMock = createMock(RequestDispatcher.class);
expect(requestMock.getRequestDispatcher("/User/login.jsp"))
    .andReturn(dispatcherMock);
// Expect to be forwarded.
dispatcherMock.forward(requestMock, responseMock);
EasyMock.expectLastCall().once();
replay(dispatcherMock);
replay(requestMock);

// Run your test on whatever instance has `execute`:
someInstance.execute(requestMock, responseMock);