HttpURLConnection httpcon = (HttpURLConnection) ((new URL("a url").openConnection()));
httpcon.setDoOutput(true);
httpcon.setRequestProperty("Content-Type", "application/json");
httpcon.setRequestProperty("Accept", "application/json");
httpcon.setRequestMethod("POST");
httpcon.connect();

byte[] outputBytes = "{'value': 7.5}".getBytes("UTF-8");
OutputStream os = httpcon.getOutputStream();
os.write(outputBytes);

os.close();