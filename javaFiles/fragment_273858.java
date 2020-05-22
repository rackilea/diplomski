public class ItemsBean implements Serializable {
    private User user;
    private List<Item> items;

    public User getUser() {
        if (user == null) {
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            Principal principal = ctx.getUserPrincipal();
            user = ... // load user: username = principal.getName()
        }
        return user;
    }

    public List<Item> getItems() {
        if (items == null) {
            User user = getUser();
            List<Item> = ... // load items as shown above
        }
        return items;
    }
}