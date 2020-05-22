URLConnection connection = (new URL(src)).openConnection();

Thread.sleep(2000); //Delay to comply with rate limiting
connection.setRequestProperty("User-Agent", USER_AGENT);

InputStream in = connection.getInputStream();