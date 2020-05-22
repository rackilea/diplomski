JSONObject jsonObject = null;
    InputStream inputSrem = clientResponse.getEntityInputStream();
    BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputSrem, "UTF-8"));
    StringBuilder responseStrBuilder = new StringBuilder();

       String inputStr;

       while ((inputStr = streamReader.readLine()) != null)
           responseStrBuilder.append(inputStr);

       jsonObject = new JSONObject(responseStrBuilder.toString());