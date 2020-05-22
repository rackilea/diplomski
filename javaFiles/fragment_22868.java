@Test
public void firstNameMaxPermittedLength() {
    Userdata userdata = minimumRequirements();
    userdata.setFirstName(utf8Chars(64));
    assertNoViolations(cut.validate(userdata));

    userdata.setFirstName(utf8Chars(65));
    assertSingleViolation(cut.validate(userdata));
}