public void createJson() {
        try {
            // create outer json
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("apikey", "example api key");
            jsonObject.put("id", "example id");

            // create email json
            JSONObject emailJsonObject = new JSONObject();
            emailJsonObject.put("email", "email");
            emailJsonObject.put("euid", "euid");
            emailJsonObject.put("leid", "leid");

            // add email json to outer json
            jsonObject.put("email", emailJsonObject);

            System.out.println("-----printing json------" + jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }