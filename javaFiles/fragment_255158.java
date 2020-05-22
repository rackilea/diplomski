URL url = new URL("...");
URLConnection conn = url.openConnection();
conn.setRequestProperty("X-Parse-Application-Id", "...");
conn.setRequestProperty("X-Parse-REST-API-Key", "...");
JSONTokener tokener = new JSONTokener(conn.getInputStream());
...