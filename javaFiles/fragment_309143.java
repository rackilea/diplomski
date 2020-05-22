HttpURLConnection httpConn;
                  URL url = new URL("adr");

                  URLConnection connection = url.openConnection();
                  int statusCode = httpConn.getResponseCode();

                   if (connection instanceof HttpURLConnection) {
                      try{
                          httpConn = (HttpURLConnection) connection;

                     if (statusCode <= 200 && statusCode < 300) {
                             // means the connection was successful
                             //do crawling
                       }
             }
     } 
                   catch (ConnectException ex) { java.util.logging.Logger.getLogger(crawler.class.getName()).log(Level.SEVERE, null, ex);}  //catch the possible exception.
                   catch (SSLHandshakeException |SocketException | SocketTimeoutException | UnknownHostException ex) {java.util.logging.Logger.getLogger(crawler.class.getName()).log(Level.SEVERE, null, ex);
                   //replace crawler with the name of your program main class