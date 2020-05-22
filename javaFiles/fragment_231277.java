HttpURLConnection conn = (HttpURLConnection) url.openConnection();
   conn.setRequestMethod("GET");
   conn.setRequestProperty("Accept","application/json");
   BufferedReader br = new BufferedReader(new InputStreamReader ( ( conn.getInputStream() ) ) );
   GResults results = new Gson().fromJson(br, GResults.class);

   for (int i=0; i<10; i++)
   results.getThing(i);