@ParameterizedTest
@ValueSource(strings = {"test@test.com", "test123@test123.com"})
void testUserEmailValidationWithValidUserEmailShouldPass(String validUserEmail) {
    boolean isValid = UserCredentialsValidator.emailValidator(validUserEmail);
    assertTrue(isValid);
}

@ParameterizedTest
@ValueSource(strings = {"username", "123username"})
void testUserNameValidationWithValidUserNameShouldPass(String validUserName) {
    boolean isValid = UserCredentialsValidator.usernameValidation(validUserName);
    assertTrue(isValid);
}