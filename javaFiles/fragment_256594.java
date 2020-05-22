public class RepeatingSequenceRegexTest {
    final PasswordValidator validator = new PasswordValidator(
            new IllegalRegexRule("(.{1,})\\1")
    );

    @Test
    public void checks() {
        assertTrue(validator.validate(new PasswordData("normal")).isValid());
        assertTrue(validator.validate(new PasswordData("abcdef")).isValid());
        assertTrue(validator.validate(new PasswordData("abacadaeaf")).isValid());
        assertTrue(validator.validate(new PasswordData("xyzxy")).isValid());
        assertTrue(validator.validate(new PasswordData("12345")).isValid());
        assertTrue(validator.validate(new PasswordData("121314")).isValid());
        assertTrue(validator.validate(new PasswordData("1234123121")).isValid());
        assertTrue(validator.validate(new PasswordData("123xy123")).isValid());
        assertTrue(validator.validate(new PasswordData("1")).isValid());
        assertTrue(validator.validate(new PasswordData("")).isValid());

        assertFalse(validator.validate(new PasswordData("apple")).isValid());
        assertFalse(validator.validate(new PasswordData("banana")).isValid());
        assertFalse(validator.validate(new PasswordData("112233")).isValid());
        assertFalse(validator.validate(new PasswordData("123123")).isValid());
        assertFalse(validator.validate(new PasswordData("1212")).isValid());
        assertFalse(validator.validate(new PasswordData("11")).isValid());
        assertFalse(validator.validate(new PasswordData("123xy123xy")).isValid());
    }
}