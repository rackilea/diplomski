public static XStream getOrCreateXStreamToUnmarshall(){
    if(XSTREAM_TO_UNMARSHALL != null){
      return XSTREAM_TO_UNMARSHALL;
    }
    XmlFriendlyNameCoder replacer = new XmlFriendlyNameCoder("-", "");
    return createXStream(XSTREAM_TO_UNMARSHALL, replacer);
  }

  public static XStream getOrCreateXStreamToMarshall() {
    if(XSTREAM_TO_MARSHALL != null){
      return XSTREAM_TO_MARSHALL;
    }
    XmlFriendlyNameCoder replacer = new XmlFriendlyNameCoder("-", "_");
    return createXStream(XSTREAM_TO_MARSHALL, replacer);
  }

  private static XStream createXStream(XStream xSTreamToInitialize, XmlFriendlyNameCoder encoder){
    QNameMap qname = new QNameMap();
    qname.setDefaultNamespace(XMLNS_VAUDOISE);
    StaxDriver staxDriver = new StaxDriver(qname, encoder);
    xSTreamToInitialize = new XStream(staxDriver);
    xSTreamToInitialize.processAnnotations(new Class[] { DocumentEnteteDto.class, 
      DocumentDto.class, 
      ReferenceDto.class,
      ObjetMetierDto.class, 
      ObjetMetierSinistreDto.class,
      ObjetMetierAnnonceDto.class,
      ObjetMetierContratDto.class,
      ObjetMetierFactureDto.class,
      ObjetMetierMutationDto.class});
    xSTreamToInitialize.registerConverter(new DateConverter("yyyy-MM-dd'T'HH:mm:ss", new String[] { "yyyy-MM-dd",
    "yyyy-MM-dd'T'HH:mm:ss" }));
    xSTreamToInitialize.registerConverter(new JodaDateConverter());
    xSTreamToInitialize.registerConverter(BooleanConverter.BINARY);
    return xSTreamToInitialize;
  }