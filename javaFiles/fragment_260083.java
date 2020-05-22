public boolean handleMessage(SOAPMessageContext smc) {
     StringBuffer sbuf = new StringBuffer();
     sbuf.append("\n------------------------------------\n");
     sbuf.append("In SOAPHandler " + HandlerName + ":handleMessage()\n");

     Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

     if (outboundProperty.booleanValue()) {
        sbuf.append("\ndirection = outbound ");
     }
     else {
        sbuf.append("\ndirection = inbound ");
     }

     SOAPMessage message = smc.getMessage();      
     try {
        sbuf.append("\n");
        sbuf.append(message.toString()); 
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        message.writeTo(baos);                     
        sbuf.append("\nMessage Desc:"+baos.toString());         
        sbuf.append("\n");
     }
     catch (Exception e) {
        sbuf.append("Exception in SOAP Handler: " + e);
     }

     sbuf.append("Exiting SOAPHandler " + HandlerName + ":handleMessage()\n");
     sbuf.append("------------------------------------\n");
     logger.debug(sbuf.toString());
     return true;
  }