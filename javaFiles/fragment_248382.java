String urlString =  URLEncoder.encode("word", "UTF-8") + "=" + URLEncoder.encode("молоко", "UTF-8");

DataOutputStream os = new DataOutputStream(connection.getOutputStream());
BufferedWriter dataOut = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

dataOut.write(urlString);