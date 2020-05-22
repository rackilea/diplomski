String checkSumUri = "https://anupg.jfrog.io/anupg/api/search/checksum?sha1=" + checkSum;
HttpResponse rtFactResponse = callService (checkSumUri, true);
BufferedReader br = new BufferedReader(new InputStreamReader((rtFactResponse.getEntity().getContent())));

String output;
StringBuffer outputBuffer = new StringBuffer("");
while ((output = br.readLine()) != null) {
    outputBuffer.append(output);
}

String uri = null;
if (!outputBuffer.toString().trim().equals("")) {
    JSONObject jsonObj = new JSONObject(outputBuffer.toString());
    JSONArray jsonArray = jsonObj.getJSONArray("results");

    for (int i=0; i < jsonArray.length(); i++) {
        JSONObject jsonUriObject = (JSONObject) jsonArray.get(i);
        System.out.println("URI---------->" + jsonUriObject.getString("uri").replace(".jar", ".pom"));
        uri = jsonUriObject.getString("uri").replace(".jar", ".pom");
    }
}

if (uri != null) {

    String downloadURI = null;
    HttpResponse uriResponse = callService (uri);

    BufferedReader uriBR = new BufferedReader(new InputStreamReader(
            (uriResponse.getEntity().getContent())));

    String uriOutput;
    StringBuffer uriOutputBuffer = new StringBuffer("");
    while ((uriOutput = uriBR.readLine()) != null) {
        uriOutputBuffer.append(uriOutput);
    }

    if (!uriOutputBuffer.toString().trim().equals("")) {
        JSONObject jsonUriObject = new JSONObject(uriOutputBuffer.toString());
        System.out.println("Download URI---------->" + jsonUriObject.getString("downloadUri"));
        downloadURI = jsonUriObject.getString("downloadUri");
    }

    HttpResponse downloadUriResponse = callService (downloadURI, true);

    if (downloadUriResponse.getStatusLine().getStatusCode() != 200) {
        throw new RuntimeException("Failed : HTTP error code : "
                + downloadUriResponse.getStatusLine().getStatusCode());
    }   

    InputStream is = downloadUriResponse.getEntity().getContent();
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    Document doc = null;

    try {
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(is);
        doc.getDocumentElement().normalize();
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (SAXException e) {
        e.printStackTrace();
    } finally {
        if (is != null) {
            is.close();
        }
    }

    System.out.println("root of xml file: " + doc.getDocumentElement().getNodeName());
    Element element = doc.getDocumentElement();

    if (getNodeValue("groupId", element) != null && 
            getNodeValue("artifactId", element) != null && 
            getNodeValue("version", element) != null) {
        metadata.setGroupId(getNodeValue("groupId", element));
        metadata.setArtifactId(getNodeValue("artifactId", element));
        metadata.setVersion(getNodeValue("version", element));
        metadata.setRTfactoryFound(true);
    }
}