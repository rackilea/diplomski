@Autowired
private Jaxb2Marshaller     serviceMarshaller;

javax.xml.transform.stream.StreamResult result = new StreamResult(new StringWriter());
serviceMarshaller.marshal(request, result);
String xml = result.getWriter().toString();