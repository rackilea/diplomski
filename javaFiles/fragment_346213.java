Response response;
        String xmlRequest= buildMerchantNBPreferencesRequest(accountNumber,emailID,thresholdValue);
        Variant variant = new Variant(MediaType.APPLICATION_XML_TYPE, null, null, "XML");        
        Invocation.Builder builder = merchantPreferencesClient.request().header("Content-Encoding", "XML").property("Content-Encoding", "XML");
        Invocation invocation =    builder.header("Content-Encoding", "XML").buildPost(Entity.entity(xmlRequest, variant));
        response = invocation.invoke();