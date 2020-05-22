public void onResponse(String response) {
                    try {
                        JSONObject objRes = new JSONObject(response);
                        MacAuth = objRes.getString("statusCode");
                        // Toast.makeText(getApplicationContext(), objRes.toString(), Toast.LENGTH_LONG).show();

                        if(MacAuth.equals("yes")) {
                            Log.i("checkMain", MacAuth);
                            intent = new Intent(Splash_Screen.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Log.i("checkErr", MacAuth);
                            intent = new Intent(Splash_Screen.this, Error_Mac_Authentication.class);
                            startActivity(intent);
                            finish();
                        }

                    } catch (JSONException e) {
                        //Log.e("TAG", "Error " + error.getMessage());
                        e.getStackTrace();
                       // Toast.makeText(getApplicationContext(), mac, Toast.LENGTH_LONG).show();
                    }
                    Log.i("macadresssented",mac);
                    Log.i("MAC", response);
                    Log.i("MacAuth",MacAuth);
                  //  Toast.makeText(getApplicationContext(), MacAuth, Toast.LENGTH_LONG).show();
                }