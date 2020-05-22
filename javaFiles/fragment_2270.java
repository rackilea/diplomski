public void process(Exchange exchange) throws Exception {
        Message inMessage = exchange.getIn();
        gdspHeader = inMessage.getHeader(GDSP_HEADER, com.vodafone.gdsp.ws.GdspHeader.class);
        commModule = inMessage.getHeader(COMM_MODULE_HEADER, resmed.hi.ngcs.datastore.model.CommModule.class);
        SetDeviceDetailsv4_Type deviceDetails = createSetDeviceDetailsv4(commModule);

        List<Object> params = new ArrayList<>();
        params.add(deviceDetails);
        params.add(gdspHeader);

        inMessage.setBody(params);

    }
`