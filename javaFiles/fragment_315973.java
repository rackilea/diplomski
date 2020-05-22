String https_url = "https://www.google.com/";
  URL url;
  try {

     url = new URL(https_url);
     HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

  } catch (MalformedURLException e) {
     e.printStackTrace();
  }