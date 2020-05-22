@Before
public void setUp() throws Exception {
    userBookLimiter = EasyMock.createMock(UserBookLimiter.class);
    EasyMock.expect(userBookLimiter.getMaxNumberOfBooksAllowed()).andReturn(5);
    EasyMock.replay(userBookLimiter);
}