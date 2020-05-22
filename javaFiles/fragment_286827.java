public class MainLayout extends Div implements RouterLayout {
}

@ParentLayout(MainLayout.class)
public class MenuBar extends Div implements RouterLayout {
    public MenuBar() {
        addMenuElement(TutorialView.class, "Tutorial");
        addMenuElement(IconsView.class, "Icons");
    }
    private void addMenuElement(Class<? extends Component> navigationTarget,
            String name) {
        // implementation omitted
    }
}

@Route(value = "tutorial", layout = MenuBar.class)
public class TutorialView extends Div {
}

@Route(value="icons", layout = MenuBar.class)
public class IconsView extends Div {
}