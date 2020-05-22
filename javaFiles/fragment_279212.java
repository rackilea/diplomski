private List<Item> list;
private DataModel<Item> model;

@PostConstruct
public void init() {
    list = itemService.list();
    model = new ListDataModel<Item>(list);
}