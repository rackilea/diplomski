@Rule
public ExpectedException thrown = ExpectedException.none();

@Test
public void shouldThrowExceptionForInvalidString() {

    thrown.expect(CustomException.class);
    thrown.expectMessage("String has the invalid word!");

    MyClass myCls = new MyClass();
    Method valStr = myCls.getClass().getDeclaredMethod("validateString", String.class);
    valStr.setAccessible(true);
    valStr.invoke(myCls, "This is theDummyWord find it if you can.");

}