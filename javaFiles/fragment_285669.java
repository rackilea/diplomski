public void writeTo(List<Data> list, Class<?> type, Type genericType, Annotation[] annotations,
        MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
        OutputStream entityStream) throws IOException, WebApplicationException {

    Charset c = Charset.forName("UTF-8");
    String cName = c.name();

    entityStream.write(String.format("<?xml version=\"1.0\" encoding=\"%s\" standalone=\"yes\"?>", cName).getBytes(cName));

    entityStream.write(String.format("<%s>", myWrapElemName).getBytes(cName));
    InstrumentModelListProvider();
    for (Data o : list){
      try {
          marshaller.marshal(o, entityStream);
      } catch(JAXBException exp) {
         exp.printStackTrace();
          //System.exit(-1);
      }
    }

    entityStream.write(String.format("</%s>", myWrapElemName).getBytes(cName));
}