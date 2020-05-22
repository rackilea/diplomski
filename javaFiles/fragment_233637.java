for (String ipAddress : ipAddresses)
{
    try (Socket socket new Socket(ipAddress, port))
    {
        System.out.println(ipAddress+":"+port+" is listening");
    }
    catch (IOException exc)
    {
        System.out.println(ipAddress+":"+port+" connection failure: "+exc);
    }
}