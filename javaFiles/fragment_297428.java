HttpURLConnection connection = null;
try
{
    URL url = new URL("http://www.studenti.ict.uniba.it/esse3/ListaAppelliOfferta.do");
    connection = (HttpURLConnection) url.openConnection(); // open the connection with the url

    String params =
            "fac_id=1012&cds_id=197"; // You need to add ad_id, docente_id and data

    connection.setRequestMethod("POST"); // i need to use POST request method
    connection.setRequestProperty("Content-Length", "" + Integer.toString(params.getBytes().length)); // It will add the length of params

    connection.setRequestProperty("Content-Language", "it-IT"); // language italian

    connection.setUseCaches (false);
    connection.setDoInput   (true);
    connection.setDoOutput  (true);

    DataOutputStream wr = new DataOutputStream(
            connection.getOutputStream ());
    wr.writeBytes (params); // pass params
    wr.flush (); // send request
    wr.close ();

    //Get Response
    InputStream is = connection.getInputStream();
    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
    String line;
    StringBuilder response = new StringBuilder();
    while((line = rd.readLine()) != null) {
        response.append(line);
        response.append('\r');
    }
    rd.close();
}
catch (MalformedURLException e)
{
    e.printStackTrace();
} catch (IOException e)
{
    e.printStackTrace();
}
finally
{
    // close connection if created
    if (connection != null)
        connection.disconnect();
}