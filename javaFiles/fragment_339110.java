HttpURLConnection con = (HttpURLConnection) new URL("https://www.shazam.com/myshazam/download-history").openConnection();
con.setRequestMethod("GET");
con.addRequestProperty("Cookie","registration=Cooki_Value_Here;profile-data=Cookie_Value_Here");
BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String inputLine;
    while ((inputLine = in.readLine()) != null) 
    System.out.println(inputLine);
    in.close();