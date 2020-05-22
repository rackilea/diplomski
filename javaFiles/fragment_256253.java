public void moveProjectToGroup(String projectName, String groupName) throws IOException
{
    int id_project = getProjectId(projectName); //32
    int id_group = getGroupId(groupName); //14

    String path = "groups/"+id_group+"/projects/"+id_project;
    String urlParameters = "id="+id_group+"&projectid="+id_project;



    //String urlParameters = "name="+name;

    URL url_request = new URL(remote+path);
    System.out.println(url_request.toString());

    HttpURLConnection url_con = (HttpURLConnection) url_request.openConnection();           

    url_con.setDoOutput(true);
    url_con.setDoInput(true);
    url_con.setInstanceFollowRedirects(false); 
    url_con.setRequestMethod("POST"); 
    url_con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
    url_con.setRequestProperty("charset", "utf-8");
    url_con.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
    url_con.setRequestProperty("PRIVATE-TOKEN", "7wHppgzq4HxbxvZVWyso"); // my admin token
    url_con.setUseCaches (false);

    OutputStreamWriter writer = new OutputStreamWriter(url_con.getOutputStream());

    writer.write(urlParameters);
    writer.flush();

    String line;
    BufferedReader reader = new BufferedReader(new InputStreamReader(url_con.getInputStream()));

    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
    writer.close();
    reader.close(); 
    url_con.disconnect();
}