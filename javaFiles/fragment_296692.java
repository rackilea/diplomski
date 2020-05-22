CreateRequisitionRO product = new CreateRequisitionRO();
        XStream xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.alias("product", Product.class);

        System.out.println(xstream.toXML(product));