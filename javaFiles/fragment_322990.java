public enum SubMenu implements Enumerable<SubMenu> {

    MENU_OPTION_1("An Option"),
    MENU_OPTION_2("Another Option";

    private final String localizedName;

    private SubMenu(final String localizedName){
        this.localizedName = localizedName;
    }

    @Override
    public String getName() {
        return this.localizedName;
    }

    @Override
    public SubMenu getByName(final String pName) {
        for(SubMenu menu : values()){
            if(menu.name().equals(pName) 
                    || menu.localizedName.equals(pName)){
                return menu;
            }
        }
        return null;
    }    
}

public class ClientClass{

    /**
     * This method can work with SubMenu, if you explicitly exchange the generic E with SubMenu
     */
    public <E extends Enum<E>> E getSubMenuOptions(final Enumerable<E> submenu){
        E sm = submenu.getByName(submenu.getName());

        return sm;
    }
}