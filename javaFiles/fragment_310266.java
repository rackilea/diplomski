try {

    String link = "http://api.aladhan.com/v1/timingsByCity?city=Penang&country=Malaysia&method=8";
    URL url = new URL(link);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");

    int responseCode = conn.getResponseCode();
    if (responseCode == 200) {
    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
    String output;
    String totalString = "" ;
    while ((output = br.readLine()) != null) {
    totalString += output;
    }
    System.out.println(totalString);


    com.google.gson.JsonObject jsonObject = new JsonParser().parse(totalString).getAsJsonObject();

    String fajr = jsonObject.getAsJsonObject("data").getAsJsonObject("timings").get("Fajr").getAsString();
    System.out.println(fajr);
    }
    }
    catch(Exception e) 
    {
    e.printStackTrace();
    }