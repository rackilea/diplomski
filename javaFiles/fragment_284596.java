URL url = new URL("MY_URL");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
HttpURLConnection connection = (HttpURLConnection)url.openConnection();
Document doc = dBuilder.parse(new InputSource(connection.getInputStream()));
doc.getDocumentElement().normalize();
int code = connection.getResponseCode();