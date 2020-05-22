SOAPBody soapBody = envelope.getBody();
SOAPElement soapBodyElem = soapBody.addChildElement("Get_Workers_Request", "wd", "urn:com.workday/bsvc");
SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("Request_References", "wd");
SOAPElement soapBodyElem2 = soapBodyElem1.addChildElement("Worker_Reference", "wd");
SOAPElement soapBodyElem3 = soapBodyElem2.addChildElement("ID", "wd");
soapBodyElem3.setAttribute("wd:type", "Employee_ID");
soapBodyElem3.addTextNode("123");