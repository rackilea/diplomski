try {
        String urlParameters =  "name=toni&class=one&param3=ok"; 
        byte[] postData = urlParameters.getBytes(Charset.forName("UTF-8"));
        int postDataLength = postData.length;
        String request = "http://rocks.php";
        URL url = new URL(request);
        HttpURLConnection cox = (HttpURLConnection) url.openConnection();
        cox.setDoOutput(true);
        cox.setDoInput(true);
        cox.setInstanceFollowRedirects(false);
        cox.setRequestMethod("POST");
        cox.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        cox.setRequestProperty("charset", "utf-8");
        cox.setRequestProperty("Content-Length",
                Integer.toString(postDataLength));
        cox.setUseCaches(false);
        OutputStreamWriter writer = new OutputStreamWriter(
                cox.getOutputStream());

        writer.write(urlParameters);
        writer.flush();
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                cox.getInputStream()));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        writer.close();
        reader.close();
    } catch (Exception e) {

        result = e.toString();
        Sucess = false;
        e.printStackTrace();
 }