@LocalizedException(expectedExceptionsMessageBundle = "bundle.name.goes.here",
      expectedExceptionsMessageLocaleProvider = "functionReturningListOfLocales"
      expectedExceptionsMessageKey = "MESSAGE_KEY_GOES_HERE")
@Test(dataProvider = "getInvalidLetters",
      expectedExceptions = {IllegalArgumentException.class)
public void test() {
  // ...
}