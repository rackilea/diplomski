documentBuilder.setEntityResolver(new EntityResolver()
        {
            public InputSource resolveEntity(String publicId, String systemId)
                throws SAXException, IOException
            {
                return new InputSource(new StringReader(""));
            }
        });