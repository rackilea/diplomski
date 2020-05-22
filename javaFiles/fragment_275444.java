InputStream response = httpcon.getInputStream();

String responseString = Helpers.convertStreamToString(response);
Log.d("WebInterface", responseString);

return responseString;