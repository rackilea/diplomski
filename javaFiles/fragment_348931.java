JSONObject jsonObject = new JSONObject();
 jsonObject .put("field", 222);
        JSONObject mainObject = new JSONObject();
        try {
            mainObject .put("data",jsonObject);
            mainObject .put("timestamp","2015-05-13T12:23:42.648738");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }