List<WebElement> PayloadXml = driver.findElements(By.xpath("//tr[@ng-repeat='field in fields']"));
    System.out.println("payload");

    for (WebElement P : PayloadXml)
        System.out.println(P.getText());

    List<WebElement> PayloadXmlvalues = driver.findElements(By.xpath("//div[@class='kbnDocViewer__value']"));
    String payload = "<CreditReturnRequest>";
    for (WebElement V : PayloadXmlvalues)
        System.out.println(V.getText());

    for (int i = 0; i <= PayloadXmlvalues.size(); i++) {
        // System.out.println("Content text is : " + PayloadXml.get(i).getText());
        // match the content here in the if loop
        if (PayloadXml.get(i).getText().contains(payload)) {

            String xmlvalues = PayloadXmlvalues.get(i).getText();
            String xmlOutputFile = "data.xml";