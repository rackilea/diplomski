public class DatabaseOperator {



    private Configuration configuration = Configuration.DEFAULT;
    private AuthDetails authDetails = AuthDetails.DEFAULT;

    public DatabaseOperator withConfigurationsFrom(String fileName) {
        //Get the configurations from the file, and initialize the 'Configuration' object
        configuration = initializeFrom(fileName);
        return this;
    }

    public DatabaseOperator withAuthenticationDetailsFrom(String fileName) {
        // Get authentication details from the file, and initialize AuthenticationDetails
        authDetails = initializeAuthDetailsFrom(fileName);
        return this;
    }

    //.. and so on

    public void initiateConnection() {
        //Uses configuration and authDetails
    }

}