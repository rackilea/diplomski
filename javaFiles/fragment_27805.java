URL url = new URL(urlString);
HttpURLConnection connection = (HttpURLConnection)url.openConnection();
 //Set to POST
connection.setDoOutput(true);
connection.setRequestMethod("POST");
connection.setDoInput(true);
//Added referer
connection.addRequestProperty("REFERER", "http://thetechguru.in");
connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
connection.setReadTimeout(10000);
Writer writer = new OutputStreamWriter(connection.getOutputStream());
writer.write(query);
writer.flush();
writer.close();