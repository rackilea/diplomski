public void testDomSizeLimits() {
        try {
            for (int i=1; i<Integer.MAX_VALUE; i*=2) {
                System.err.println("Trying size " + i);
                Configuration config = new Configuration();
// Change the next line depending on the chosen tree model
                TinyBuilder writer = new TinyBuilder(config.makePipelineConfiguration());
                Location loc = ExplicitLocation.UNKNOWN_LOCATION;
                writer.open();
                writer.startDocument(0);
                writer.startElement(new NoNamespaceName("doc"), Untyped.getInstance(), loc, 0);
                for (int j=0; j<i; j++) {
                    writer.startElement(new NoNamespaceName("elem"), Untyped.getInstance(), loc, 0);
                    writer.characters("The quick brown fox", loc, 0);
                    writer.endElement();
                }
                writer.endDocument();
                writer.close();
            }
        } catch (XPathException e) {
            e.printStackTrace();
        }
    }