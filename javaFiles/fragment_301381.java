private List<Item> items;
private DataModel<Item> model;  // +getter

@PostConstruct
public void init() {
    this.items = loadItSomehow();
    this.model = new ListDataModel<Item>(items);
}