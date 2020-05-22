XmlHolder xmlHolder = null;
 try {
    xmlHolder = new XmlHolder(soapOperation.createRequest(true));
    } catch (XmlException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    };

    // Here tagCell.getStringCellValue() = FromCurrency

    System.out.println("FromCurrency= " + request.getNodeValue("//*:" + tagCell.getStringCellValue()));
    request.setNodeValue("//*:" + tagCell.getStringCellValue() , valCell.getStringCellValue());