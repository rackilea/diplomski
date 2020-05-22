public static void send(String pathname) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException
{

    try
    {
    System.out.println("....");

    byte[] buf = new byte[1024];
    OutputStream os = sock.getOutputStream();
    //PrintWriter writer = new PrintWriter(os);
    System.out.println("...11.");