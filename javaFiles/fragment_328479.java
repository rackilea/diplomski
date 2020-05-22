OMFactory fac = OMAbstractFactory.getOMFactory();
    SOAPFactory sfac = OMAbstractFactory.getSOAP11Factory();

    OMNamespace omNs = fac.createOMNamespace(nameSpace, "ns1");

    SOAPHeaderBlock block_RequestSOAPHeader = sfac.createSOAPHeaderBlock(
    SOAPHEADER_RequestSOAPHeader, omNs);

    try
    {
        SOAPHeaderBlock block_spId = sfac.createSOAPHeaderBlock(SOAPHEADER_SPID, omNs);
        block_spId.addChild(sfac.createOMText(spId));

        String md_password = md5Digest(spId, spPassword, timeStamp);
        SOAPHeaderBlock block_spPassword = sfac.createSOAPHeaderBlock(SOAPHEADER_SPPASSWORD, omNs);
        block_spPassword.addChild(sfac.createOMText(md_password));

        SOAPHeaderBlock block_timeStamp = sfac.createSOAPHeaderBlock(SOAPHEADER_TIMESTAMP, omNs);
        block_timeStamp.addChild(sfac.createOMText(timeStamp));

        SOAPHeaderBlock block_serviceId = sfac.createSOAPHeaderBlock(SOAPHEADER_SERVICEID, omNs);
        block_serviceId.addChild(sfac.createOMText("your text"));


        SOAPHeaderBlock block_linkId = sfac.createSOAPHeaderBlock(SOAPHEADER_LINKID, omNs);
        block_linkId.addChild(sfac.createOMText(linkID));

        SOAPHeaderBlock block_OA = sfac.createSOAPHeaderBlock(SOAPHEADER_OA, omNs);
        block_OA.addChild(sfac.createOMText(OA));

        SOAPHeaderBlock block_FA = sfac.createSOAPHeaderBlock(SOAPHEADER_FA, omNs);
        block_FA.addChild(sfac.createOMText(FA));

        block_RequestSOAPHeader.addChild(block_spId);
        block_RequestSOAPHeader.addChild(block_spPassword);
        block_RequestSOAPHeader.addChild(block_serviceId);
        block_RequestSOAPHeader.addChild(block_timeStamp);
        block_RequestSOAPHeader.addChild(block_linkId);
        block_RequestSOAPHeader.addChild(block_OA);
        block_RequestSOAPHeader.addChild(block_FA);


        /*
         *
         *  <soapenv:Header>
         *    <ns1:RequestSOAPHeader xmlns:ns1="http://www.xxxxxxxx.xxxxxx.xxxxxx/common/v2_1">
         *      <ns1:spId>your spid</tns:spId>
         *      <ns1:spPassword>your password</tns:spPassword>
         *      <ns1:timeStamp>your timestamp</tns:timeStamp>
         *      <ns1:linkId>your linkid</tns:linkId>
         *      <ns1:OA>tel:your msisdn1</tns:OA>
         *      <ns1:FA>tel:msisdn1</tns:FA>
         *    </ns1:RequestSOAPHeader>
         *  </soapenv:Header>
         */

        serviceClient.addHeader(block_RequestSOAPHeader);