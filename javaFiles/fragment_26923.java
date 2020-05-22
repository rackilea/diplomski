public Element marshallToElement(Object specific, Class clazz) throws JAXBException{
        DOMResult res = null;
        JAXBContext ctx = JAXBContext.newInstance(clazz);
        Marshaller marshaller = ctx.createMarshaller();
        res = new DOMResult();
        marshaller.marshal(specific, res);
        return ((Document)res.getNode()).getDocumentElement();
    }