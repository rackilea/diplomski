@Override
            public void onCompleted(JSONObject object,GraphResponse response) {
                if (response != null) {
                    try {
                        email = object.getString("email");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        gender = object.getString("gender");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
  if(email!=null && gender!=null){
new Upload_Data().execute();
}
            }
        });