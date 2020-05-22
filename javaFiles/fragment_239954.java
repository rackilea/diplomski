URL url = new URL(target);
URLConnection conn = url.openConnection();
conn.setRequestProperty("User-Agent",
        "Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");
conn.connect();
BufferedReader serverResponse = new BufferedReader(
        new InputStreamReader(conn.getInputStream()));
System.out.println(serverResponse.readLine());
serverResponse.close();