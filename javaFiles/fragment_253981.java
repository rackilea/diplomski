try {

        final StringBuffer sb = new StringBuffer();

        ClientInterceptor clientInterceptor = new ClientInterceptor() {

            @Override
            public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
                WebServiceMessage message = messageContext.getResponse();
                ByteArrayOutputStream bytArrayOutputStream = new ByteArrayOutputStream();
                try {
                    message.writeTo(bytArrayOutputStream);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                String test = new String(bytArrayOutputStream.toByteArray());
                sb.append(test);
                // System.out.println(test);
                return true;
            }

            @Override
            public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
                // TODO Auto-generated method stub
                return true;
            }

            @Override
            public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
                // TODO Auto-generated method stub
                return true;
            }
        };
        ClientInterceptor[] interceptors = interceptors = new ClientInterceptor[1];
        interceptors[0] = clientInterceptor;
        ws.setInterceptors(interceptors);
        final StringBuffer sbuffer = new StringBuffer();                   

        SoegPersonCprResponse response =  (SoegPersonCprResponse) ws.marshalSendAndReceive(uri, request,
            new WebServiceMessageCallback() {
                @Override
                public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
                    ByteArrayOutputStream os = new ByteArrayOutputStream();
                    message.writeTo(os);
                    sbuffer.append(new String(os.toByteArray()));
                }
            });
     } catch (Exception e) {
        throw e;
     }