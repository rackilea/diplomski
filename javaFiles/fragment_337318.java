schemaFactory.setResourceResolver(new LSResourceResolver(){
    @Override
    public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
            // resovle the path to schema , read and return it.
    }

});