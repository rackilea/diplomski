static public ArrayList<String> getTxt(String urlString){
    ArrayList<String> list=new ArrayList<String>();
    //Access the page
    try {
        // Create a URL for the desired page
        URL url = new URL(urlString);

        // Read all the text returned by the server
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String str;
        while ((str = in.readLine()) != null) {
            list.add(str);
            // str is one line of text; readLine() strips the newline character(s)
        }
        in.close();             
    } catch (MalformedURLException e) {
    } catch (IOException e) {
    }          
    return list;
}