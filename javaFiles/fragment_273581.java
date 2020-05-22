@Route
public class TabTest extends VerticalLayout implements RouterLayout {

    private Map<Tab, String> tabToUrlMap = new LinkedHashMap<>();
    private Div contentContainer = new Div();

    public TabTest() {
        Tabs tabs = createTabs();
        Div contentContainer = new Div();
        contentContainer.setSizeFull();
        add(tabs, contentContainer);

        tabs.addSelectedChangeListener(e ->
                UI.getCurrent().navigate(tabToUrlMap.get(e.getSelectedTab())));
    }

    private Tabs createTabs() {
        RouteConfiguration routeConfiguration = RouteConfiguration.forApplicationScope();

        tabToUrlMap.put(new Tab("View 1"), routeConfiguration.getUrl(TestView1.class));
        tabToUrlMap.put(new Tab("View 2"), routeConfiguration.getUrl(TestView2.class));
        tabToUrlMap.put(new Tab("View 3"), routeConfiguration.getUrl(TestView3.class));
        return new Tabs(tabToUrlMap.keySet().toArray(new Tab[]{}));
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        getElement().appendChild(content.getElement());
    }
}