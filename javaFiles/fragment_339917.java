public class Example {

    private Integer id;
    private String description;

    public Example(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}

@Override
public void init() {
    Window mainWindow = new Window("Combobox Application");

    List<Example> examples = new ArrayList<Example>();
    examples.add(new Example(new Integer(1), "First description"));
    examples.add(new Example(new Integer(2), "Second description"));
    examples.add(new Example(new Integer(3), "Third description"));
    BeanItemContainer<Example> objects = new BeanItemContainer(Example.class, examples);

    ComboBox combo = new ComboBox("Example", objects);
    combo.setItemCaptionPropertyId("description");

    mainWindow.addComponent(combo);
    setMainWindow(mainWindow);
}