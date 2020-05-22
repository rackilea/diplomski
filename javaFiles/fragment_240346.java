String urlParameters = "url=testingThis";
 String url = "http://shmkane.com/index.php?";
 URL obj = new URL(url + urlParameters);
 HttpURLConnection con = (HttpURLConnection) obj.openConnection();

 con.setRequestMethod("GET");