@Test
public void testValidEmail() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    SendEmailImpl instance = new SendEmailImpl();
    Method method = instance.getClass().getDeclaredMethod("isValidEmailAddress", String.class);
    method.setAccessible(true);
    Boolean invoke = (Boolean) method.invoke(instance, "myStringArgument");
    // rest of code
}