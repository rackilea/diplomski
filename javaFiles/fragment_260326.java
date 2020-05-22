public class AmirRachum {

    public static void main(String[] args) {
        try{
            int port=38824;

            ServerSocket listeningSocket=new ServerSocket(port);
            System.out.println("Socket created");

            while (true) {
                Socket serverSocket;
                Socket clientSocket;
                BufferedWriter toClient;
                BufferedWriter toServer;
                try {
                    //The client is meant to put data on the port, read the socket.
                    clientSocket = listeningSocket.accept();
                    Request request = new Request(clientSocket.getInputStream());
                    System.out.println("Accepted a request!\n" + request);
                    while(request.busy);
                    //Make a connection to a real proxy.
                    //Host & Port - should be read from the request
                    URL url = null;
                    try {
                        url = new URL(request.getRequestURL());
                    } catch (MalformedURLException e){
                        url = new URL("http:\\"+request.getRequestHost()+request.getRequestURL());
                    }

                    //remove entry from cache if needed
             /*       if (!request.getCacheControl().equals(CacheControl.CACHE) && cache.containsRequest(request)) {
                        cache.remove(request);
                    }*/

                    Response response = null;

             /*       if (request.getRequestType() == RequestType.GET && request.getCacheControl().equals(CacheControl.CACHE) && cache.containsRequest(request)) {
                        response = cache.get(request);
                    } else*/ {
                        //Get the response from the destination
                        int remotePort = (url.getPort() == -1) ? 80 : url.getPort();
                        System.out.println("I am going to try to connect to: " + url.getHost() + " at port " + remotePort);
                        serverSocket = new Socket(url.getHost(), remotePort);
                        System.out.println("Connected.");

                        //write to the server - keep it open.
                        System.out.println("Writing to the server's buffer...");
                        toServer = new BufferedWriter(new OutputStreamWriter(serverSocket.getOutputStream()));
                        toServer.write(request.getFullRequest());
                        toServer.flush();
                        System.out.println("flushed.");

                        System.out.println("Getting a response...");
                        response = new Response(serverSocket.getInputStream());
                        System.out.println("Got a response!\n" + response);
                        //wait for the response
                        while(response.isBusy());   
                    }

            /*        if (request.getRequestType() == RequestType.GET && request.getCacheControl().equals(CacheControl.CACHE)) {
                        cache.put(request, response);
                    }

                    response = filter.filter(response);*/

                    // Return the response to the client
                    toClient = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    toClient.write(response.getFullResponse());
                    toClient.flush();
                    toClient.close();

                } catch (IOException e) {
                    e.printStackTrace();
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Request {
        private String fullRequest = "";
        private BufferedReader reader;
    //    private RequestHeader requestHeader;
        private String requestHost;
        private String requestURL;
        boolean busy = true;
    //    private CacheControl cacheControl = CacheControl.CACHE;

     /*   public CacheControl getCacheControl() {
            return cacheControl;
        }*/

        Request(String request) {
            this(new ByteArrayInputStream(request.getBytes()));
        }

        Request(InputStream input){
            reader = new BufferedReader(new InputStreamReader(input));
            try {
                while(!reader.ready()); //wait for initialization.

                String line;
                while ((line = reader.readLine()) != null) {
                    if(!line.startsWith("Accept-Encoding:")) fullRequest += "\r\n" + line;

                /*    if (HttpPatterns.CACHE_CONTROL.matches(line)) {
                        cacheControl = (CacheControl) HttpPatterns.RESPONSE_CODE.process(line);
                    } else if (HttpPatterns.REQUEST_HEADER.matches(line)) {
                        requestHeader = (RequestHeader) HttpPatterns.REQUEST_HEADER.process(line);
                    } else if (HttpPatterns.HOST.matches(line)) {
                        requestHost = (String) HttpPatterns.HOST.process(line);
                    }*/
                    if(line.startsWith("GET ")){requestURL=line.split(" ")[1];System.out.println("url \""+requestURL+"\"");}
                    if(line.startsWith("Host:")){requestHost=line.substring(6);System.out.println("Host \""+requestHost+"\"");}
                    if(line.length()==0){System.out.println("empty line");break;}
                }
                fullRequest = "\r\n" + fullRequest.trim() + "\r\n\r\n";
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            busy = false;
        }

        public String getFullRequest() {
            return fullRequest;
        }

    /*    public RequestType getRequestType() {
            return requestHeader.type;
        }*/

        public String getRequestURL() {
            return requestURL;
        }

    /*    public String getRequestProtocol() {
            return requestHeader.protocol;
        }*/

        public String getRequestHost() {
            return requestHost;
        }

        public boolean isBusy() {
            return busy;
        }

        //@Override
        public String toString() {
            return "Request\n==============================\n" + fullRequest;
        }
    }

    public static class Response {
        private String fullResponse = "";
        private BufferedReader reader;
        private boolean busy = true;
    //    private int responseCode;
    //    private CacheControl cacheControl;

        public Response(String input) {
            this(new ByteArrayInputStream(input.getBytes()));
        }

        public Response(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            try {
                while (!reader.ready());//wait for initialization.

                String line;
                while ((line = reader.readLine()) != null) {
                    fullResponse += "\r\n" + line;

               /*     if (HttpPatterns.RESPONSE_CODE.matches(line)) {
                        responseCode = (Integer) HttpPatterns.RESPONSE_CODE.process(line);
                    }/* else if (HttpPatterns.CACHE_CONTROL.matches(line)) {
                        cacheControl = (CacheControl) HttpPatterns.CACHE_CONTROL.process(line);
                    }*/
                }
                reader.close();
                fullResponse = "\r\n" + fullResponse.trim() + "\r\n\r\n";
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            busy = false;
        }

    /*    public CacheControl getCacheControl() {
            return cacheControl;
        }*/

        public String getFullResponse() {
            return fullResponse;
        }

        public boolean isBusy() {
            return busy;
        }

     /*   public int getResponseCode() {
            return responseCode;
        }*/

        //@Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result
                    + ((fullResponse == null) ? 0 : fullResponse.hashCode());
            return result;
        }

        //@Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (!(obj instanceof Response))
                return false;
            Response other = (Response) obj;
            if (fullResponse == null) {
                if (other.fullResponse != null)
                    return false;
            } else if (!fullResponse.equals(other.fullResponse))
                return false;
            return true;
        }

        //@Override
        public String toString() {
            return "Response\n==============================\n" + fullResponse;
        }
    }

}