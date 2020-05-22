StringBuffer buffer = new StringBuffer();
buffer.append("access_token").append('=').append(ACCESS_TOKEN);
buffer.append('&').append("message=").append('=').append("YO!");
String content = buffer.toString();

URLConnection connection = new URL("https://graph.facebook.com/me/feed").openConnection();
connection.setDoOutput(true);
connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
connection.setRequestProperty("Content-Length", Integer.toString(content.length()));

DataOutputStream out = new DataOutputStream(connection.getOutputStream());
out.writeBytes(content);
out.flush();
out.close();

BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
String inputLine;
while ((inputLine = in.readLine()) != null) { 
    System.out.println(inputLine);
}

in.close();