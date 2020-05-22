public static void main(String args[]) {
        String fromClient = "www.mmix.cs.hm.edu";

        try(ServerSocket welcomeSocket = new ServerSocket(8082)){
            System.out.println("Server started, waiting for clients...");
            while(true){
                StringBuilder htmlCode = new StringBuilder();
                try(Socket connectionSocket = welcomeSocket.accept();
                        DataOutputStream toClient = new DataOutputStream(connectionSocket.getOutputStream());
                        BufferedReader fromBrowser = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()))){

                        String line1 = fromBrowser.readLine(); //Line 1 is of format: GET /index.html HTTP/1.1
                        String dynUrl = line1.substring(line1.indexOf(32)+1,line1.lastIndexOf(32)); //dynUrl is of format:/index.html
                        //Please note that the query string parameters not taken into account and the code may fail if the query string contains space character.
                        //Construct a new URL based on dynUrl
                        try(InputStream url = new URL("http://"+fromClient+dynUrl).openStream();
                                BufferedReader getUrl = new BufferedReader(new InputStreamReader(url))){
                                for(String line = getUrl.readLine(); line != null; line = getUrl.readLine()){
                                    htmlCode.append(line);
                                }
                                String str = htmlCode.toString();
                                toClient.writeBytes(str);
                                    //toClient.write("\r\n");
                        }
                }
            }
        }
        catch(IOException io){
            io.printStackTrace();
        }
    }