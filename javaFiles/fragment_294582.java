public class GetReportsResponseHandler extends   DefaultHandler<GetReportsResponse> {

private XmlMapper mapper = new XmlMapper();
public GetReportsResponseHandler() {
super(new GetReportsResponse(), "get_reports_response");
AnnotationIntrospector primary = new JacksonAnnotationIntrospector();
AnnotationIntrospector secondary = new JaxbAnnotationIntrospector();
AnnotationIntrospector pair = new AnnotationIntrospectorPair(primary,         secondary);
mapper.setAnnotationIntrospector(pair);
}

@Override
protected void parseStartElement(XMLStreamReader parser) throws    XMLStreamException, IOException {
    if ("report".equals(parser.getName().toString())){
        Report report = mapper.readValue(parser, Report.class);
        response.addReport(report);
    }