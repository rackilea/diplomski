HttpURLConnection = (HttpURLConnection)url.openConnection();
String encoding = ... // get encoding from http header
InputSource source = new InputSpource(url.openStream());
source.setEncoding(encoding);
DocumentBuilder db = ... // create doc builder
Document doc = db.parse(source);