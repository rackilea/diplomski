class COAUTHIDENTITY extends Structure {
  public Pointer User;
  public int UserLength;
  public Pointer Domain;
  public int DomainLength;
  public Pointer Password;
  public int PasswordLength;
  public int Flags;
}