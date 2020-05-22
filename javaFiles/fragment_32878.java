public interface MenuAction extends Action {

    public MenuController getController();
}

public abstract class AbstractMenuAction extends AbstractAction implements MenuAction {

    private MenuController controller;

    public AbstractMenuAction(MenuController controller, String name) {
        this.controller = controller;
        putValue(NAME, name);
    }

    @Override
    public MenuController getController() {
        return controller;
    }

}