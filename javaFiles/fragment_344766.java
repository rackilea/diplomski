@Test
public void shouldThrowExceptionForInvalidString() {

    try {
        MyClass myCls = new MyClass();
        Method valStr = myCls.getClass().getDeclaredMethod(
                "validateString", String.class);
        valStr.setAccessible(true);
        valStr.invoke(myCls, "This is theDummyWord find it if you can.");
    } catch (Exception e) {
        assert(e instanceOf CustomException);
        assert(e.getMessage.equals("String has the invalid word!"));
    }

}