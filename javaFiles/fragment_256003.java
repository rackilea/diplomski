class Params {
  @Parameter(names = "--user", description = "the User")
  String user;
  @Parameter(names = "--password", description = "the password")
  String password;

}

public static void main(String[] args) {
  Params p = new Params();
  new JCommander(p).parse("--user hugo  david --password secret".split(" "));
  System.out.println(p.user);
  System.out.println(p.password);
}