Parameters parameters3 = new Parameters();

        parameters3.setName("K3");
        parameters3.setSyntax(SyntaxType.CONTAINER);
        Value paramvalue3 = obj.createValue();

        JAXBElement<String> name = obj.createName("ch1");
        JAXBElement<SyntaxType> synt = obj.createSyntax(SyntaxType.STRING);
        NodeValue ch1Value = obj.createNodeValue();

        ch1Value.getContent().add("KPStringChild1");    
        paramvalue3.getContent().add(name);
        paramvalue3.getContent().add(synt);
        paramvalue3.getContent().add(ch1Value);
        parameters3.getValue().add(paramvalue3);