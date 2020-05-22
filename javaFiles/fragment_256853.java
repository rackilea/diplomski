private BlockingGameObserver observer;

@Before
public void setUp() throws IOException, Exception {
    observer = new BlockingGameObserver();
    GameInstance.getInstance().addObserver(observer); 
}

@Test
public void getRoomUserData_usingNullKey_shouldThrowUserDataDoesntExist() throws InterruptedException, UserDataDoesntExistException {
    serverService.createRoom("exampleRoom");   
    observer.waitUntilUpdateIsCalled();
    assertEquals("exampleRoom",
                 GameInstance.getInstance().getRoom("exampleRoom").getRoomId());
}