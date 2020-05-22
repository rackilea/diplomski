StreamSource source = new StreamSource(new StringReader(msgText));
StreamResult result = new StreamResult(System.out);               
webServiceTemplate.sendSourceAndReceiveToResult(
            uri,
            source,
            result);