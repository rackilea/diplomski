URLConnection connection = new URL("https://graph.facebook.com/me/feed").openConnection();
connection.setDoOutput(true);
connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

DataOutputStream out = new DataOutputStream(connection.getOutputStream());
out.writeBytes(data);
out.flush();
out.close()