/* FROM JAVA APPLET EXECUTE JSON GET */

    public static String getJson(String parameter) throws ClientProtocolException, IOException {

        String url = "http://somedomain.com/VaadinApp?parameter=";

        String resp="";
        HttpClient client = new DefaultHttpClient();

        HttpGet request = new HttpGet(url + parameter); // here you put the entire URL with the GET parameters

        HttpResponse response = client.execute(request);

// from here is postprocessing to handle the response, in my case JSON

        BufferedReader rd = new BufferedReader (new   InputStreamReader(response.getEntity().getContent()));
        String line = "";
        StringBuilder sb = new StringBuilder("");

        while ((line = rd.readLine()) != null) {
            sb.append(line);
    }



// if defined, this will return the response of the vaadin application, for this example no response is given from the server
        return sb.toString();
}