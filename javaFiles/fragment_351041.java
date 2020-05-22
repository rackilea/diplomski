private void connectToServerAndReadData()
{
     HttpURLConnection conn;
     boolean result = false;

         try{
             // Enter any URL here you want to connect
             URL url = new URL("http://php1.funnymedialinks.com/scribd/rcheck.php");

            // Open a HTTP connection to the URL

             conn = (HttpURLConnection) url.openConnection();
            // conn.connect();
              BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
              String line ;



              while ((line = rd.readLine()) != null) {

                       Log.v("Readed Data from Server ","data- "+line);

              }



            rd.close();


         }catch(MalformedURLException e){

                 e.printStackTrace();
         }
         catch(IOException e){
                 e.printStackTrace();               
         }
        catch(Exception e){
                 e.printStackTrace();           
         }





}