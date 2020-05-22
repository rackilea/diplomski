HttpConnection connection = null;
InputStream inputstream = null;
String url = null;
StringBuffer dataReceived = null;

    url = "http://www.google.com/index.php?v1=x&v=y";
    dataReceived = new StringBuffer();

    try {
        connection = (HttpConnection) Connector.open(url);
        connection.setRequestMethod(HttpConnection.GET);
        connection.setRequestProperty("Content-Type", "text/plain");
        connection.setRequestProperty("Connection", "close");

        if (connection.getResponseCode() == HttpConnection.HTTP_OK) {
            inputstream = connection.openInputStream();
            int ch;
            while ((ch = inputstream.read()) != -1 ) {
                dataReceived.append((char) ch);

            }
        } else {
            // Connection not ok
        }
    } catch (Exception e) {
      // Something went wrong
    } finally {
        if (inputstream != null) {
            try {
                inputstream.close();
            } catch (Exception e) {
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
    }