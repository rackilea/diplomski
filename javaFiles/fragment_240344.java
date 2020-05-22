try
{
    InetAddress ipAddress = InetAddress.getByName( "google.com" );
    String range = "192.168";           
    System.out.println(isInPrivateRange( ipAddress, range ));
}
catch ( UnknownHostException e )
{
    e.printStackTrace();
}