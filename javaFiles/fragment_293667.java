public class Main extends JFrame {
    JTabbedPane tab;

    public Main() {
       // ... other stuff
       UIManager.put("TabbedPane.contentAreaColor ",ColorUIResource.GREEN);
       UIManager.put("TabbedPane.selected",ColorUIResource.GREEN);
       UIManager.put("TabbedPane.background",ColorUIResource.GREEN);
       UIManager.put("TabbedPane.shadow",ColorUIResource.GREEN);

       // now construct the tabbed pane
       tab=new JTabbedPane();

       // ... other stuff
 }