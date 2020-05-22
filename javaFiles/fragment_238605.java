NodeList textCBarcode = PackageBarcodeElement .getChildNodes();
           System.out.println("CBarcode: " + 
                  ((Node)textCBarcode.item(0)).getNodeValue().trim());

 /////
 /////   You will continue as the same methood in order to make deep iteration
 /////
           }