HttpURLConnection urlc = null;
DataOutputStream dataout = null;
URL url = new URL(URL_LOGIN_SUBMIT);
urlc = (HttpURLConnection) url.openConnection();
// set up post
...
dataout = new DataOutputStream(urlc.getOutputStream());
dataout.writeBytes(output);
int responseCode = urlc.getResponseCode();