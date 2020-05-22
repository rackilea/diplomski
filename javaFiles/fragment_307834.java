public class SecuredView extends VerticalLayout implements View {

    public SecureView() {
        addComponent(new Label("Secured View"));
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

}