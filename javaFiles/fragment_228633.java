public class XMLUtils<MODEL extends AbstractModel, WRAPPER extends WraperInterface<MODEL>> {

private WRAPPER wrapperInstance;

public XMLUtils(Class<WRAPPER> wrapperInstance) throws InstantiationException, IllegalAccessException {
    this.wrapperInstance = wrapperInstance    
 }
 //more code follows
}