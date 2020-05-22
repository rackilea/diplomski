public class SubComponent extends SuperComponent {
    // override actionEvent in SuperComponent
    @Override
    public void actionEvent() {
        super.actionEvent();
        doAdditionalStuff();
    }
}