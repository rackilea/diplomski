private boolean checkConnectionWithOneRetry()
{
    try 
    {
        // Sends a NOOP command to the FTP server. 
        boolean answer = ftpClient.sendNoOp();
        if(answer)
            return true;
        else
        {
            System.out.println("Server connection failed!");
            boolean success = reconnect();
            if(success)
            {
                System.out.println("Reconnect attampt have succeeded!");
                return true;
            }
            else
            {
                System.out.println("Reconnect attampt failed!");
                return false;
            }
        }
    }
    catch (FTPConnectionClosedException e) 
    {
        System.out.println("Server connection is closed!");
        boolean recon = reconnect();
        if(recon)
        {
            System.out.println("Reconnect attampt have succeeded!");
            return true;
        }
        else
        {
            System.out.println("Reconnect attampt have failed!");
            return false;
        }

    }
    catch (IOException e) 
    {
        System.out.println("Server connection failed!");
        boolean recon = reconnect();
        if(recon)
        {
            System.out.println("Reconnect attampt have succeeded!");
            return true;
        }
        else
        {
            System.out.println("Reconnect attampt have failed!");
            return false;
        }   
    }
    catch (NullPointerException e) 
    {
        System.out.println("Server connection is closed!");
        boolean recon = reconnect();
        if(recon)
        {
            System.out.println("Reconnect attampt have succeeded!");
            return true;
        }
        else
        {
            System.out.println("Reconnect attampt have failed!");
            return false;
        }   
    }
}