protected void init(VaadinRequest request)
{
    VerticalLayout layout = new VerticalLayout();
    Collection<Person> people = new ArrayList<Person>();
    people.add(new Person("Nicolaus Copernicus", 1543));
    people.add(new Person("Galileo Galilei", 1564));
    people.add(new Person("Johannes Kepler", 1571));

    BeanItemContainer<Person> container = new BeanItemContainer<Person>(Person.class, people);
    Grid grid = new Grid(container);
    layout.addComponent(grid);

    com.vaadin.ui.JavaScript.getCurrent().addFunction("rowClicked", new JavaScriptFunction()
    {
        @Override
        public void call(JsonArray arguments)
        {
            System.out.println(arguments.get(0).toString());
        }
    });
    com.vaadin.ui.JavaScript.getCurrent().execute("addRowListener()");

    setContent(layout);
}