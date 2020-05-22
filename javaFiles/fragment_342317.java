private void validateNamePart(String npart) {
  if (!npart.matches("")) {
    throw new .....;
  }
}

private void validateName(String name) {
  int parts = 0;
  for (String npart : name.split("\\.")) {
    validateNamePart(npart);
    parts++;
  }
  if (parts == 0) {
     throw ....;
  }
}

private void validateDomainPart(String dpart) {
  ....
}

private void validateDomain(String domain) {
  ....
}

public void validateEMail(String email) {
  String parts = email.split("@");
  if (parts.length == 2) {
    validateName(parts[0]);
    validateDomain(parts[1]);
  } else {
    throw ....
  }
}