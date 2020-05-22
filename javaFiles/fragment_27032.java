wmService = new WMServiceStub();

            Options options = new Options();
            EndpointReference epr = new EndpointReference(url);
            options.setTo(epr); 
            options.setProperty(HTTPConstants.SO_TIMEOUT, new Integer(300000));             

            wmService._getServiceClient().setOptions(options);