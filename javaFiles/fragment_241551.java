public class MainPanel extends JPanel implements Pageable {
    //...
    @Override
    public void showView(String name) {
        cl.show(panelHolder, name);
    }