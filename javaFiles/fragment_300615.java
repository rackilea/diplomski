try {

   InputSource file = new InputSource("filterns.xml");

   XMLFilterImpl xf = new XMLFilterImpl(
           XMLReaderFactory.createXMLReader()) {
       @Override
       public void startElement(String uri, String localName,
           String qName, Attributes atts) throws SAXException {

               AttributesImpl aImpl = new AttributesImpl();

                int l = atts.getLength();
                for (int i = 0; i < l; i++) {

                    if (atts.getQName(i) != null
                            && atts.getQName(i).startsWith("xmlns")) {
                        continue;
                    } else {
                        String aQName = atts.getQName(i);
                        String[] s = aQName.split(":");
                        if (s.length > 1) {
                            aQName = s[1];
                        }

                        aImpl.addAttribute("",
                                atts.getLocalName(i), aQName,
                                atts.getType(i), atts.getValue(i));
                    }

                }

                String[] s = qName.split(":");
                if (s.length > 1) {
                    super.startElement("", localName, s[1], aImpl);
                } else {
                    super.startElement("", localName, qName, aImpl);
                }

       }

       @Override
       public void endElement(String uri, String localName,
              String qName) throws SAXException {

              String[] s = qName.split(":");
              if (s.length > 1) {
                 super.endElement("", localName, s[1]);
               } else {
                  super.endElement("", localName, qName);
                 }

       }

       @Override
       public void startPrefixMapping(String prefix, String uri) {
       }

   };

   xf.setFeature("http://xml.org/sax/features/namespaces", false);
   SAXSource src = new SAXSource(xf, file);

   StringWriter stringWriter = new StringWriter();
   TransformerFactory transformerFactory = TransformerFactory
           .newInstance();
   Transformer transformer = transformerFactory.newTransformer();
   transformer.setOutputProperty(OutputKeys.INDENT, "yes");
   transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,"yes");
   transformer.transform(src, new StreamResult(stringWriter));

   String xml = stringWriter.toString();
   System.out.println(xml);

} catch (Exception e) {
   e.printStackTrace();
}