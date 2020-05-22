protected Collection<String> generatedPasswords = new HashSet<String>();
public String generatePassword(int length) {
  String password = null;
  do {
    StringBuilder buf = new StringBuilder();
    // Append "length" random password characters to "buf".
    password = buf.toString();
  } while (this.generatedPasswords.contains(password));
  return password;
}