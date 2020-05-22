private static void usingTransformerHandler(Result to) throws Exception {
    TransformerHandler first = XSLT2.newTransformerHandler(Inputs.xsl1());
    TransformerHandler second = XSLT2.newTransformerHandler(Inputs.xsl2());

    LocatorFixer fixer = new LocatorFixer();
    first.setResult(new SAXResult(fixer.wrap(second)));
    second.setResult(to);

    XSLT2.newTransformer().transform(Inputs.in(), new SAXResult(fixer.wrap(first)));
  }

  private static void usingXMLFilter(Result to) throws Exception {
    XMLReader r = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
    XMLFilter first = XSLT2.newXMLFilter(Inputs.xsl1());
    XMLFilter second = XSLT2.newXMLFilter(Inputs.xsl2());

    LocatorFixer fixer = new LocatorFixer();
    first.setParent(fixer.wrap(r));
    second.setParent(fixer.wrap(first));

    XSLT2.newTransformer().transform(Inputs.in(second), to);
  }