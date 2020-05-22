class HTTPThread extends Thread {
     URL url;
     boolean success = false;
     String pass;
     PrimeThread(Url url,String pass) {
         this.url = url;
         this.pass = pass;
     }

     public void run() {
         HttpURLConnection con = (HttpURLConnection) url.openConnection();

         //add request header
         con.setRequestMethod("POST");
         con.setRequestProperty("User-Agent", "Mozilla/5.0  etc.");
         con.setRequestProperty("Accept-Language", "en-US,en;q=0.8");
         con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         con.setRequestProperty("Connection", "keep-alive");
         con.setRequestProperty("Accept", "*/*");
         con.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");




         String urlParameters = "name=userName&pwd="+pass;

         // Send post request
         con.setDoOutput(true);
         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
         wr.writeBytes(urlParameters);
         wr.flush();
         wr.close();

         int responseCode = con.getResponseCode();

         BufferedReader in = new BufferedReader(
                 new InputStreamReader(con.getInputStream()));
         String inputLine;
         StringBuffer response = new StringBuffer();

         while ((inputLine = in.readLine()) != null) {
             response.append(inputLine);
         }
         in.close();

         //if password is not correct, my form should return false
         if (response.toString().equals("false"))
             success= false;
         else 
             success= true;
         }
     }
     public String getPassword(){return pass;}
     public boolean isSuccess(){return success;}
 }