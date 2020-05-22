URL url = null;
try {
   url = new URL("http://localhost:8080/putservice");
} catch (MalformedURLException exception) {
    exception.printStackTrace();
}
HttpURLConnection httpURLConnection = null;
DataOutputStream dataOutputStream = null;
try {
    httpURLConnection = (HttpURLConnection) url.openConnection();
    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    httpURLConnection.setRequestMethod("PUT");
    httpURLConnection.setDoInput(true);
    httpURLConnection.setDoOutput(true);
    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
    dataOutputStream.write("hello");
} catch (IOException exception) {
    exception.printStackTrace();
}  finally {
    if (dataOutputStream != null) {
        try {
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    if (httpsURLConnection != null) {
        httpsURLConnection.disconnect();
    }
}