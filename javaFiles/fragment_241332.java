public static void main(String[] args) {
        String xml = "<?xml version='1.0' encoding='UTF-8'?>"
                + "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">" + "<S:Body>"
                + "<ns2:processResponse xmlns:ns2=\"http://ws.xxxxx.com/\">"
                + "<response><direction>response</direction>" + "<reference>09FG10021008111306320</reference>"
                + "<amount>0.0</amount>" + "<totalFailed>0</totalFailed>" + "<totalSuccess>0</totalSuccess>"
                + "<error>1</error>" + "<message>Invalid</message>"
                + "<otherReference>6360e28990c743a3b3234</otherReference>" + "<action>FT</action>"
                + "<openingBalance>0.0</openingBalance>" + "<closingBalance>0.0</closingBalance>" + "</response>"
                + "</ns2:processResponse>" + "</S:Body>" + "</S:Envelope>\n";

        SAXBuilder builder = new SAXBuilder();
        Reader in = new StringReader(xml);
        Document doc = null;
        Element root = null;
        Element error = null;
        Element status_message = null;
        String status_code = "";
        String message = "";
        try {
            doc = builder.build(in);
            root = doc.getRootElement();
            Element body = root.getChild("Body", Namespace.getNamespace("S", "http://schemas.xmlsoap.org/soap/envelope/"));
            Element processResponse = body.getChild("processResponse", Namespace.getNamespace("ns2", "http://ws.xxxxx.com/"));
            Element response = processResponse.getChild("response");
            error = response.getChild("error");
            status_message = response.getChild("message");
            status_code = error.getText();
            message = status_message.getText();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("status_code: " + status_code + "\nmessage: " + message);
    }