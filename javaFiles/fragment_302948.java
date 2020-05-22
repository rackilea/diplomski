try 
    {
        JSONObject jObj = new JSONObject(response);
        String  respCode = jObj.getString("resp_code");
        //boolean error = jObj.getBoolean("error");

        if (respCode.equals("200")) {
            String user = jObj.getJSONObject("user").getString("name");
            Toast.makeText(getApplicationContext(), "Hi " + user +", You are successfully Added!", Toast.LENGTH_SHORT).show();

            // Launch login activity
            Intent intent = new Intent(
                    Login.this,
                    MainActivity.class);
            startActivity(intent);
            finish();
        } else {

            String errorMsg = jObj.getString("error_msg");
            Toast.makeText(getApplicationContext(),
                    errorMsg, Toast.LENGTH_LONG).show();
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }