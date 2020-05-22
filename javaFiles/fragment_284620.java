public class SchemaNamespaceCollectorEventReader extends EventReaderDelegate
{
    @SuppressWarnings("serial")
    public class SchemaDocumentNamespace implements Serializable
    {   
        /** targetNamespace */
        private String targetNamespaceURI;
        /** Keyed by prefix */
        private Map<String, String> namespaceURIMapping = new LinkedHashMap<String, String>();

        public void setTargetNamespaceURI(String targetNamespaceURI)
        {
            this.targetNamespaceURI = targetNamespaceURI;
        }
        public String getTargetNamespaceURI()
        {
            return targetNamespaceURI;
        }
        public Map<String, String> getNamespaceURIMapping()
        {
            return Collections.unmodifiableMap(namespaceURIMapping);
        }
        public void addNamespaceURIMapping(String prefix, String URI)
        {
            namespaceURIMapping.put(prefix, URI);
        }
        public final NamespaceContext getNamespaceContext()
        {
            return new SimpleNamespaceContext(namespaceURIMapping);
        }

        @Override
        public String toString()
        {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }

    private SchemaDocumentNamespace namespaces;
    public SchemaNamespaceCollectorEventReader(XMLEventReader xsr)
    {
        super(xsr);
    }

    @Override
    public XMLEvent nextEvent() throws XMLStreamException
    {
        final XMLEvent e = super.nextEvent();
        if(e.getEventType() == XMLStreamConstants.START_ELEMENT)
        {
            final StartElement startElement = e.asStartElement();
            if(startElement.getName().equals(new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI, "schema")))
            {
                this.namespaces = collectXmlns(startElement);
            }
        }
        return e;
    }

    private SchemaDocumentNamespace collectXmlns(StartElement e)
    {
        final SchemaDocumentNamespace namespaces = new  SchemaDocumentNamespace();
        final Attribute targetNSAttr = e.getAttributeByName(new QName("targetNamespace"));
        if(targetNSAttr != null)
        {
            namespaces.setTargetNamespaceURI(targetNSAttr.getValue());
        }
        final NamespaceContext nsCtx = e.getNamespaceContext();
        for(final Iterator i = e.getNamespaces();i.hasNext();)
        {
            final Namespace ns = (Namespace) i.next();
            final String uri = ns.getNamespaceURI();
            final String prefix = ns.getPrefix();
            final String value = ns.getValue();

            namespaces.addNamespaceURIMapping(prefix, value);
        }

        return namespaces;
    }

    public SchemaDocumentNamespace getNamespaces()
    {
        return namespaces;
    }
}