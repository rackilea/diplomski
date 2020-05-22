public class MyClass {
    private static final Method GET_PHONE_NUM = MyUtils.lookupMethod( PhoneNumber.class, "getPhoneNumber" );

    ....

    public void someMethod() {
        validateField(data, GET_PHONE_NUM, options);
    }
}