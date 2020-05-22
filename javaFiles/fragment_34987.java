@Test(expectedExceptions = {IllegalArgumentException.class},
    expectedExceptionsMessageRegExp = PasswordValidator.INVALID_PASSWORD,
    dataProvider = "invalid-passwords")
public void testInvalidPasswords(String password) throws Exception {
    new LaxPasswordValidator(password);
}