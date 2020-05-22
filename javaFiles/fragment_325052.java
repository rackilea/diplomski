HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setDoOutput(true);
conn.setDoInput(true);
conn.setRequestMethod("POST");
conn.setFixedLengthStreamingMode(params.getBytes().length);
conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

PrintWriter out = new PrintWriter(conn.getOutputStream());
out.print(params);
out.close();

String response = "";
Scanner inStream = new Scanner(conn.getInputStream());

while (inStream.hasNextLine()) {
    response += (inStream.nextLine());
}