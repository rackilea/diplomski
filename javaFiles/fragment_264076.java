HttpURLConnection con = null;
    String url_str = "https://graph.microsoft.com/v1.0/me";
    String bearer_token = "EwA4A8l6BA...";

    URL url = new URL(url_str);
    con = ( HttpURLConnection )url.openConnection();
    con.setDoInput(true);
    con.setDoOutput(true);
    con.setUseCaches(false);
    con.setRequestMethod("GET");
    con.setRequestProperty("Authorization","Bearer " + bearer_token);
    con.setRequestProperty("Accept","application/json"); // I added this line.
    con.connect();

    BufferedReader br = new BufferedReader(new InputStreamReader( con.getInputStream() ));
    String str = null;
    String line;
    while((line = br.readLine()) != null){
        str += line;
    }
    System.out.println(str);