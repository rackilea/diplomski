public class MenuBall {
    private MenuBot1 menuBot1;
    (...)

    // this constructor doesn't need a MenuBot1 object.
    public MenuBall(MenuView menuView) {
        (...)
    }

    // setter for the menuBot1
    public void setMenuBot1(MenuBot1 menuBot1) {
        this.menuBot1 = menuBot1;
    }

    (...)
}

public class MenuBot1 {
    private MenuBall menuBall;
    (...)

    // this constructor doesn't need a MenuBall object.
    public MenuBot1(MenuView menuView) {
        (...)
    }

    // setter for the menuBall
    public void setMenuBall(MenuBall menuBall) {
        this.menuBall = menuBall;
    }

    (...)
}