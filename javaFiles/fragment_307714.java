@XmlRootElement("configItems")
public class SomeConfigItems {

    @lombok.Getter @lombok.Setter
    private List<ConfigurationItem> items = new ArrayList<>();

    @Action(
        associateWith = "items",  // associates with the items collection
        semantics = SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE,
        domainEvent = DeletedDomainEvent.class)
    public SomeConfigItems delete(List<ConfigurationItem> items) {
        for(ConfigurationItem item: items) {
           repositoryService.remove(item);
        }
        return this;
    }
    // optionally, select all items for deletion by default
    public List<ConfigurationItem> default0Delete() { return getItems(); }

    // I don't *think* that a choices method is required, but if present then 
    // is the potential list of items for the argument
    //public List<ConfigurationItem> choices0Delete() { return getItems(); }
}