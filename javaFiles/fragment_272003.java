@XmlRootElement(name = ROOT)
public static class Root {
    static final String ROOT = "root";
    static final String ELEMENT_A = "elementA";

    @XmlElement(name = ELEMENT_A)
    public Element element_a;
    public static class Element {}
}

public static void main(String[] args) throws Exception {
    final Root root = new Root();
    root.element_a = new Root.Element();

    final JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
    final Marshaller marshaller = jaxbContext.createMarshaller();

    final XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
    final XMLStreamWriter writer = outputFactory.createXMLStreamWriter(System.out);
    final LocalizingXmlStreamWriter localizingWriter = new LocalizingXmlStreamWriter(writer, Locale.ENGLISH);
    marshaller.marshal(root, localizingWriter);
}

static class LocalizingXmlStreamWriter extends javanet.staxutils.IndentingXMLStreamWriter {
    final static Map<String, ImmutableMap<String, String>> localizations = Maps.toMap(
        Arrays.asList(Locale.ENGLISH.getLanguage(), Locale.ITALIAN.getLanguage()),
        new Function<String, ImmutableMap<String, String>>() {
            @Override
            public ImmutableMap<String, String> apply(String lang) {
                if (Locale.ENGLISH.getLanguage().equals(lang)) {
                    return Maps.toMap(Arrays.asList(ROOT, ELEMENT_A),
                        Functions.<String>identity());
                }
                else if (Locale.ITALIAN.getLanguage().equals(lang)) {
                    return Maps.toMap(Arrays.asList(ROOT, ELEMENT_A),
                        new Function<String, String>() {
                            @Override
                            public String apply(String tag) {
                                switch (tag) {
                                    case ROOT:
                                        return "radice";
                                    case ELEMENT_A:
                                        return "elementoA";
                                    default:
                                        return tag;
                                }
                            }
                        });
                }
                else throw new IllegalStateException();
            }
        }
    );

    private final ImmutableMap<String, String> localization;

    public LocalizingXmlStreamWriter(XMLStreamWriter writer, Locale locale) {
        super(writer);
        final String language = locale.getLanguage();
        localization = localizations.get(language);
        Preconditions.checkArgument(localization != null, 
            "not supported language %s", language);
    }

    @Override
    public void writeStartElement(String prefix, String localName, String namespaceURI) 
        throws XMLStreamException 
    {
        final String localizedTag = localization.get(localName);
        super.writeStartElement(prefix, localizedTag, namespaceURI);
    }
}