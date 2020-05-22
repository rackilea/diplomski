public interface MenuController {
    public void addSubMenu(SubMenuPane subMenuPane);
    public void popLastMenu();
}

public class DefaultMenuController implements MenuController {

    private MenuPane menuPane;

    public DefaultMenuController(MenuPane menuPane) {
        this.menuPane = menuPane;
    }

    @Override
    public void addSubMenu(SubMenuPane subMenuPane) {
        menuPane.addSubMenuPane(subMenuPane);
    }

    @Override
    public void popLastMenu() {
        menuPane.popLastMenu();
    }

}