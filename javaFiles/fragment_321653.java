try {
        UtilsXML.makeDoc();

        Element order = UtilsXML.addRoot("ORDER");

        Element info = UtilsXML.addElement("INFO", order);
        UtilsXML.addNode(info, "Id", "123456");
        UtilsXML.addNode(info, "Value", "99999");

        Element other = UtilsXML.addElement("OTHERS", order);
        UtilsXML.addNode(other, "Date", "01/01/2017");
        UtilsXML.addNode(other, "Status", "Finish");            

        UtilsXML.makeFile("c:/opensource/myXml.xml");
    } catch (ParserConfigurationException e) {          
        e.printStackTrace();
    }
<ORDER>
    <INFO>
        <Id>123456</Id>
        <Value>99999</Value>
    </INFO>
    <OTHERS>
        <Date>01/01/2017</Date>
        <Status>Finish</Status>
    </OTHERS>
</ORDER>