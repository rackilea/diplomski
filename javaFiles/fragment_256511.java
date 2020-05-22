CODE :

catch (IOException e) {
                try {
                    if (reConnectCount <= 10) {
                        reConnectCount++;
                        jsonResponse = doInBackground(keyValuePairs);
                    } else {
                        jsonResponse.put("status", "No Internet Connection");
                        jsonResponse.put("message", "Please check your Internet connection and try again");
                    }
                } catch (JSONException e1) {
                    GeneralUtils.print("NetworkCall.JSONEx " + e);
                }
            }