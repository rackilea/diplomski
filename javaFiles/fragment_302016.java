private static void getSecurityToken() {
        try {
            // Use the empty constructor – no need to specify wsdl
            SecurityTokenService src = new SecurityTokenService();

            // Pull the class used to negotiate WS Trust directly from the
            // SecurityTokenService
            IWSTrust13Sync trust = src.getBasicHttpBindingIWSTrust13Sync();

            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(IWSTrust13Sync.class);
            factory.setAddress(ServiceURL);
            IWSTrust13Sync service = (IWSTrust13Sync) factory.create();

            // Obtain a reference to the CXF endpoint using the ClientProxy helper:
            Client client = ClientProxy.getClient(service);

            // Set up logging if desired
            client.getOutInterceptors().add(new LoggingOutInterceptor());
            client.getInInterceptors().add(new LoggingInInterceptor());
            client.getRequestContext().put("com.sun.xml.ws.connect.timeout", 1 * 60 * 1000);
            client.getRequestContext().put("com.sun.xml.ws.request.timeout", 5 * 60 * 1000);

            // Specify the user we want to authenticate
            client.getRequestContext().put("ws-security.username", UserName);
            client.getRequestContext().put("ws-security.password", Password);

            HTTPConduit http = (HTTPConduit) client.getConduit();
            http.getAuthorization().setUserName(UserName);
            http.getAuthorization().setPassword(Password);
            http.getClient().setConnectionTimeout(36000);
            http.getClient().setAllowChunking(false);

            RequestSecurityTokenType token = new RequestSecurityTokenType();

            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element tokenType = document.createElementNS("http://docs.oasis-open.org/ws-sx/ws-trust/200512",
                    "TokenType");
            tokenType.setTextContent("http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0");

            token.getAny().add(tokenType);

            Element requestType = document.createElementNS("http://docs.oasis-open.org/ws-sx/ws-trust/200512",
                    "RequestType");
            requestType.setTextContent("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Issue");
            token.getAny().add(requestType);

            Document appliesTodoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element appliesTo = appliesTodoc.createElementNS("http://schemas.xmlsoap.org/ws/2004/09/policy",
                    "AppliesTo");

            Element endPoint = appliesTodoc.createElementNS("http://schemas.xmlsoap.org/ws/2004/08/addressing",
                    "EndpointReference");

            Element address = appliesTodoc.createElementNS("http://schemas.xmlsoap.org/ws/2004/08/addressing",
                    "Address");
            address.setTextContent("http://localhost");

            endPoint.appendChild(address);
            appliesTo.appendChild(endPoint);

            token.getAny().add(appliesTo);

            //Now specify what claims we want back.
            Document claimsDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Element claims = claimsDoc.createElementNS("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Claims");
            claims.setAttribute("Dialect", "http://schemas.microsoft.com/ws/2008/06/identity/securitytokenservice");

            // Add claims to token request
            //token.getAny().add(claims);

            RequestSecurityTokenResponseCollectionType result = service.trust13Issue(token);

            //parseResponse(result);
            List<RequestSecurityTokenResponseType> response = result.getRequestSecurityTokenResponse();

            Iterator<RequestSecurityTokenResponseType> itr = response.iterator();

            while (itr.hasNext()) {
                RequestSecurityTokenResponseType obj = itr.next();
                List<Object> responseObject = obj.getAny();
                Iterator<Object> ObjItr = responseObject.iterator();
                while (ObjItr.hasNext()) {
                    System.out.println("Result " + ObjItr.next());
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }