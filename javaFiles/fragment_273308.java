static final String kuser = "username"; // your account name
static final String kpass = password; // retrieve password for your account 

static class MyAuthenticator extends Authenticator {
    public PasswordAuthentication getPasswordAuthentication() {
        // I haven't checked getRequestingScheme() here, since for NTLM
        // and Negotiate, the usrname and password are all the same.
        System.err.println("Feeding username and password for " + getRequestingScheme());
        return (new PasswordAuthentication(kuser, kpass.toCharArray()));
    }
}

public static void main(String[] args) throws Exception {
    Authenticator.setDefault(new MyAuthenticator());
    URL url = new URL(args[0]);
    InputStream ins = url.openConnection().getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
    String str;
    while((str = reader.readLine()) != null)
        System.out.println(str);
}