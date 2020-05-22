public class ComponentRepainter {

    @Subscribe
    public void doSomething(EventObject e) {
        ((Component) e.getSource()).repaint();
    }
}