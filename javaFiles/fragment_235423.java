public class Tab extends JFrame {
  private final JTabbedPane tab=new JTabbedPane();
  private final Map<String, Component> componentsByName = new HashMap<>();

  ...
  private void addComponentToPaneAndMap(String title, Component component) {
    tab.add(title, component);
    componentsByName.put(title, component);
  }