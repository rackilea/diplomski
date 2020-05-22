ByteArrayOutputStream baos = new ByteArrayOutputStream();
XMLOutputFactory xof = XMLOutputFactory.newFactory();
XMLStreamWriter xsw = xof.createXMLStreamWriter(System.out);
xsw = new MyXMLStreamWriter(xsw);
m.marshal(iq, xsw);
xsw.close();