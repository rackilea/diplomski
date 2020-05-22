authCode = sharedPreferences.getString("code", null);
params=new String[5];
CLIENT_ID = params[0];
CLIENT_SECRET = params[1];
GRANT_TYPE = params[2];
REDIRECT_URI = params[3];
authCode = params[4];
new AsyncTaskRunner().execute(params);`