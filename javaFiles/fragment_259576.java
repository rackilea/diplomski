StringWriter stringWriter = new StringWriter();
        marshaller.marshal(programme, stringWriter);

        String xmlContent = stringWriter.toString();
        xmlContent = xmlContent.replaceAll("xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"", "");
        xmlContent = xmlContent.replaceAll("</ns2:", "</");
        xmlContent = xmlContent.replaceAll(":ns2=", "=");
        xmlContent = xmlContent.replaceAll("<ns2:", "<");

        result = xmlContent;