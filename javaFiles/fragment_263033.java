static public String getPage(String urlString){
    String result = "";
    //Access the page
    try {
     // Create a URL for the desired page
     URL url = new URL(urlString);
     // Read all the text returned by the server
     BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
     String str;
     while ((str = in.readLine()) != null) {
         // str is one line of text; readLine() strips the newline character(s)
         result += str;
     }
     in.close();             
    } catch (MalformedURLException e) {
    } catch (IOException e) {
    }          
    return result;
}