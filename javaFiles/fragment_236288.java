try {
        String hostname = "stackoverflow.com";
        String requestHeaders[][] = {
            { "Host" , hostname } ,
            { "User-Agent" , "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36" } ,

        };
        String pathname = "questions/33047629/basic-http-client-from-scratch/33047769#33047769";
        int port = 80;
        Socket socket = new Socket(hostname, port);
        InputStream inStream = socket.getInputStream();
        DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
        String data = "GET /"+pathname+" HTTP/1.1\r\n";
        for (int i=0;i<requestHeaders.length;i++){
            data += requestHeaders[0]+": "+requestHeaders[1]+"\r\n";
        }
        data += "\r\n";
        outStream.writeChars(data.getBytes());
        outStream.flush();
    }
    catch (Exception e) {
        System.out.println(e);
    }