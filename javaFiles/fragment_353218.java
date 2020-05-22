public class MyUI extends UI {
    @Override
    protected void init( VaadinRequest request ) {
        setContent( VaadinSession.getCurrent().getAttribute("userId") == null ? getNewLoginLayout() : getNewMainLayout() );
    }
    private VerticalLayout getNewLoginLayout() {
        TextField username = ...
        TextField password = ...
        Button login = ...
        return new VerticalLayout(username, password, login);
    }
}