HttpURLConnection urlConnection = (HttpURLConnection)new URL(url).openConnection();
urlConnection.setDoOutput(true);
urlConnection.setDoInput(true);
urlConnection.setRequestMethod("POST");
urlConnection.setConnectTimeout(5000);
urlConnection.setReadTimeout(60000);
urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");