@RunWith(PowerMockRunner.class)
@PrepareForTest(MyUnit.class)
public class TestMyUnit {

    @Test
    public void testSomething() {
        MyUnit unit = PowerMock.createPartialMock(MyUnit.class, "methodNameToStub");
        PowerMock.expectPrivate(unit, "methodNameToStub", param1).andReturn(retVal);

        EasyMock.replay(unit);

        unit.publicMethod(param1);

        EasyMock.verify(unit);

    }

}