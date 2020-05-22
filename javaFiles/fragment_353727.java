@Test
public void testSomething()
{
    SomeInterface mock = EasyMock.createMock(SomeInterface.class);
    SomeBase expected = new DerivesFromSomeBase();

    mock.send(expected);

    EasyMock.expectLastCall().andAnswer(new IAnswer<Object>() {
        public Object answer() {
            // do additional assertions here
            SomeBase arg1 = (SomeBase) EasyMock.getCurrentArguments()[0];

            // return null because of void
            return null;
        }
    });
}