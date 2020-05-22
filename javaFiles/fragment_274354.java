for (int i = 0; i < maxFailedAttempts; i++)
{
    try
    {
        success = connect(serverName, protocol, serverAddress, 
                                      serverPort, username, password);
        if (!success)
        {
            String message = "Could not connect to " + protocol
                                + " server " + serverName
                                + " - Authorization failed.";
            logger.debug(message);
            errorMessage = message;

            try
            {
                deactivateKPI(kpiDef, authenticateFailedMessage);
                TimeUnit.MINUTES.sleep(5);
            }
            catch (AuthenticationException ae)
            {
                // do not attempt to try again if the KPI fails with
                // authentication Exception.
                ae.printStackTrace();
            }

            break;
        }

        // Also come out of the loop if the connection was
        // successful. We do not need to continue to attempt to
        // connect.
        break;                  
    }
}