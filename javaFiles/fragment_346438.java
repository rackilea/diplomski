try {
    serverAddress = new URL("http://127.0.0.1:5000/projects/" + ruser.getUserEmail()+"+++++"+ruser.getUserHash());
    //set up out communications stuff
    connection = null;

    //Set up the initial connection
    connection = (HttpURLConnection)serverAddress.openConnection();
    connection.setRequestMethod("GET");
    connection.setDoOutput(true);
    connection.setReadTimeout(100000);

    connection.connect();

    //get the output stream writer and write the output to the server
    //not needed in this example

    rd  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    sb = new StringBuilder();

    while ((line = rd.readLine()) != null)
    {
       sb.append(line + '\n');
    }
    String mystr = sb.toString();
    // Now do the magic.
    Gson gson = new Gson();
    projectData = gson.fromJson(mystr, ProjectData[].class);    
} catch (MalformedURLException e) {
    e.printStackTrace();
} catch (ProtocolException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
finally
{
    //close the connection, set all objects to null
    connection.disconnect();
    rd = null;
    sb = null;
    connection = null;
}


return projectData;