DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder;  
        try  
        {  
            builder = factory.newDocumentBuilder();  
            Document document = builder.parse( new InputSource( new StringReader( arrayOfErrorContext ) ) );  
            NodeList nList1 = document.getElementsByTagName("item");
            //iteration Logic on nList1
        } catch (Exception e) {  
            e.printStackTrace();  
        }