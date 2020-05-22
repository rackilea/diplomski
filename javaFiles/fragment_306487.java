// Install the custom authenticator
Authenticator.setDefault(new MyAuthenticator());

// Access the page
try {
    // Create a URL for the desired page
    URL url = new URL("THE URL YOU NEED TO OPEN/ACCESS");

    // Read all the text returned by the server
    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
    String str;
    while ((str = in.readLine()) != null) {
        // str is one line of text; readLine() strips the newline character(s)
    }
    in.close();
} catch (MalformedURLException e) {
} catch (IOException e) {
}

public class MyAuthenticator extends Authenticator {
    // This method is called when a password-protected URL is accessed
    protected PasswordAuthentication getPasswordAuthentication() {
        // Get information about the request
        String promptString = getRequestingPrompt();
        String hostname = getRequestingHost();
        InetAddress ipaddr = getRequestingSite();
        int port = getRequestingPort();

        // Get the username from the user...
        String username = "myusername";

        // Get the password from the user...
        String password = "mypassword";

        // Return the information
        return new PasswordAuthentication(username, password.toCharArray());
    }
}