try {
        JSONObject jobj = new JSONObject(Respones);         
        String userid = jobj.getString("Result");               
    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }