public class SomePart {
    @PostConstruct
    public void postConstruct(Composite parent) {
        ...
        Label someLabel = new Label(parent);
        someLabel.setData(this);
        ...
    }
}