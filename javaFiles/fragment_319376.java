@Wire("#menubar ~ menuitem")
private List<Menuitem> menuitems;

@Override
public void doAfterCompose(Component component) {
    for (Menuitem menuitem : menuitems) {
        menuitem.addEventListener(Events.ON_CLICK, LISTENER);
    }
}