XsltTransformer xslt = FunctionalTestCase.muleContext.getRegistry()
                .lookupObject("SuccessResponseTransformer");
        xslt.setReturnDataType(DataType.STRING_DATA_TYPE);
        xslt.initialise();

        String result = (String) xslt.transform(srcXML);