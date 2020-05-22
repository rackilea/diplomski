// Note: this example assumes you already have a BoxAPIConnection.
URL url = new URL("files/" + file.getID() + "/content")
BoxAPIRequest request = new BoxAPIRequest(api, url, "GET");
BoxAPIResponse response = request.send();

InputStream bodyStream = response.getBody();
// Use the stream.
response.disconnect();