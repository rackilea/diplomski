/** @param String email An email with an address in the form abc@xyz.com
 * with no nested comments, periods or other nonsense.
 */
public String scanEmail(String email)
  if (!addressIsProperlyFormatted(email)) {
      throw new IllegalArgumentException("invalid address");
  }
  return parseEmail(emailAddr);
}
private String parseEmail(String emailS) {
  // Assumes email is valid
  boolean parsesJustFine = true;
  // Parse logic
  if (!parsesJustFine) {
    // As a private method it is an internal error if address is improperly
    // formatted. This is an internal error to the class implementation.
    throw new AssertError("Internal error");
  }
}