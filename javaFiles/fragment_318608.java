private Tab createMenuItem(String title, VaadinIcon icon, Class<? extends Component> target) {
    RouterLink link = new RouterLink(null,target);
    if (icon != null) link.add(icon.create());
    link.add(title);
    Tab tab = new Tab();
    tab.add(link);
    return tab;
}