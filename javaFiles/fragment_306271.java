try
    {
        Socket  s = new Socket ();
        s.bind    (new InetSocketAddress (ipFrom, 0));
        s.connect (new InetSocketAddress (ipTo,   80), 1000);

        PrintWriter     writer = new PrintWriter    (s.getOutputStream ());
        BufferedReader  reader = new BufferedReader (new InputStreamReader (s.getInputStream ()));

    writer.print ("GET " + szUrl + " HTTP/1.0\r\n"); 
//Also you can send multiple headers like this

    writer.print ("header1: value1\r\n"); 
    writer.print ("header2: value2\r\n"); 
    writer.print ("header3: value3\r\n"); 

// end the header section
writer.print ("\r\n"); 
        writer.flush ();

        s     .close ();
        reader.close ();
        writer.close ();
    }