public class Main {
public static interface JAXBElementMixinT {
    @JsonValue
    Object getValue();
}
public static void main(String[] args) throws XMLStreamException, IOException {

          ObjectMapper mapper = new ObjectMapper(); 
          JaxbAnnotationModule module = new JaxbAnnotationModule(); 
          mapper.registerModule(module)
          mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
          mapper.addMixIn(JAXBElement.class, JAXBElementMixinT.class); 
          String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
          System.out.println(result);

}