final String login = "myuser";
final String password = "mypass";
String credential = Credentials.basic(login, password);
Request request = new Request.Builder()
.url("https://api.bitbucket.org/2.0/repositories/myuser/test/pullrequests")
.header("Authorization", credential)
.get()
.build();