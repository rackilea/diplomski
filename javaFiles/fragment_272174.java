URL url = ...
  HttpURLConnection urlc = (HttpURLConnection)url.openConnection();
  urlc.setAllowUserInteraction( false );
  urlc.setDoInput( true );
  urlc.setDoOutput( false );
  urlc.setUseCaches( true );
  urlc.setRequestMethod("HEAD");
  urlc.connect();
  String mime = urlc.getContentType();
  if(mime.equals("text/html") {
    // do your stuff
  }