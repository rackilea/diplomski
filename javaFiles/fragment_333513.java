@Provider
@Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class JaxbContextResolver implements ContextResolver<JAXBContext> {

  @Override
  public JAXBContext getContext(Class<?> type) {
    // load appropriate context data
    Class[] bindTypes = ...

    // create 
    try {
      return JAXBContext.newInstance(bindTypes);
    } catch (JAXBException e) {
      // todo:  this can be handled better but works for the example
      throw new RuntimeException(e);
    }
  }
}