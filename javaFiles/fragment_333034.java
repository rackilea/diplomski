uri = new URL(oneTimeUploadUrl);

// Setup Connection
HttpsURLConnection http = (HttpsURLConnection) uri.openConnection();
http.setDoOutput(true);
http.setRequestMethod("PUT");
http.setRequestProperty("Content-Type"," "); // remove Content-Type header

// Write Data
OutputStream os = http.getOutputStream();
os.write(_bytes);
os.flush();
os.close(); // request gets sent off to the server