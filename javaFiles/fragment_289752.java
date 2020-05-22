BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

StringBuilder response = new StringBuilder();
String inputLine;

while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}

in.close();
conn.disconnect();