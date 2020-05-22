@Route
public class TabTest extends VerticalLayout {

    private Map<Tab, Component> tabComponentMap = new LinkedHashMap<>();

    public TabTest() {
        Tabs tabs = createTabs();
        Div contentContainer = new Div();
        add(tabs, contentContainer);

        tabs.addSelectedChangeListener(e -> {
            contentContainer.removeAll();
            contentContainer.add(tabComponentMap.get(e.getSelectedTab()));
        });
        // Set initial content
        contentContainer.add(tabComponentMap.get(tabs.getSelectedTab()));
    }

    private Tabs createTabs() {
        tabComponentMap.put(new Tab("Show some text"), new H1("This is the text tab"));
        tabComponentMap.put(new Tab("Show a Combo Box"), new ComboBox<String>());
        tabComponentMap.put(new Tab("Show a button"), new Button("Click me and nothing happens"));
        return new Tabs(tabComponentMap.keySet().toArray(new Tab[]{}));
    }
}