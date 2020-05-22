// Assuming 'input' is a String and contains your text
URL url = new URL("http://hostname/path");
URLConnection con = url.openConnection();
con.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
con.setDoOutput(true);
OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
out.write(input);
out.close();