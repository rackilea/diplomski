JSONObject json = new JSONObject();

            JSONObject dataJson = new JSONObject();
            dataJson.put("body", message);
            dataJson.put("title", getFirebaseUser().getDisplayName());
            json.put("notification", dataJson);
            json.put("registration_ids",jsonArray);


            StringEntity se = new StringEntity(json.toString(), "UTF-8");

            AsyncHttpClient client = new AsyncHttpClient();
            client.addHeader("Accept", "application/json");
            client.addHeader("Content-type", "application/json;charset=utf-8");
            client.addHeader("Authorization", "key=" + "xxxxxxxxxxxx");
            client.post(getInstance(), "your url", se, "application/json;charset=utf-8", new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    Log.e("success_noti", new String(responseBody) + "");

                    if(isEnd){
                        getMessage.getMessageFunc(END);
                    }

                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    Log.e("fail_noti", new String(responseBody) + "");
                }
            });