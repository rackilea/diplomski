public void sendAndReceiveXMLPayload(String xmlFileNamePath) throws IOException {

        ClassPathResource
            classPathResource =
                new ClassPathResource(xmlFileNamePath);

        Source
            requestSource = 
                new ResourceSource(classPathResource);

        StringResult
            result =
                new StringResult();

        getWebServiceTemplate().
            sendSourceAndReceiveToResult(
                requestSource,  
                new WSSESecurityHeaderRequestWebServiceMessageCallback(),
                result
            );  
    }