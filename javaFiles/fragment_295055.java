try {
    JSONObject job = new JSONObject(log);
    String param1 = job.getString("AuditScheduleDetailID");
    String param2 = job.getString("AuditAnswerId");
    String param3 = job.getString("LocalFindingID");
    String param4 = job.getString("LocalMediaID");
    String param5 = job.getString("Files");
    String param6 = job.getString("ExtFiles");
    Log.d("hasil json", param1 + param2 + param3 + param4 + param5 + param6 + " Kelar id " +
            "pertama");

    URL url = new URL("myurl");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
    conn.setRequestProperty("Accept", "application/json");
    conn.setDoOutput(true);
    conn.setDoInput(true);

    JSONObject jsonParam = new JSONObject();
    jsonParam.put("AuditScheduleDetailID", param1);
    jsonParam.put("AuditAnswerId", param2);
    jsonParam.put("LocalFindingID", param3);
    jsonParam.put("LocalMediaID", param4);
    jsonParam.put("Files", param5);
    jsonParam.put("ExtFiles", param6);

    Log.i("JSON", jsonParam.toString());
    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
    //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
    os.writeBytes(jsonParam.toString());

    os.flush();
    os.close();
    InputStream is = null;

    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
            is = conn.getInputStream();// is is inputstream
        } else {
            is = conn.getErrorStream();
        }


        try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                is, "UTF-8"), 8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        is.close();
        String response = sb.toString();
        //HERE YOU HAVE THE VALUE FROM THE SERVER
        Log.d("Your Data", response);
    } catch (Exception e) {
        Log.e("Buffer Error", "Error converting result " + e.toString());
    }


    conn.disconnect();
} catch (JSONException | IOException e) {
    e.printStackTrace();
}