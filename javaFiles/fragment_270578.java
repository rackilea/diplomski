HttpConnection con = null;
    InputStream is = null;
    try {
        System.out.println("1");
        String url = new String("http://myserver.com/index.html");

        //I added these two lines to your code and tested it with my own server and got a 200 RC.
        net.rim.device.api.io.transport.ConnectionFactory cf = new net.rim.device.api.io.transport.ConnectionFactory();
        con = (HttpConnection)cf.getConnection(url).getConnection();

        System.out.println(con.toString());
        int responseCode = con.getResponseCode();
        System.out.println("3 responseCode = " + responseCode);
        if (responseCode != HttpConnection.HTTP_OK) {
            System.out.println("3.5");
            System.out.println(responseCode);
        }