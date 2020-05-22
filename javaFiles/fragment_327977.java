public class MyComponent extends Composite implements HasWidgets {

    private static MyComponentUiBinder uiBinder = GWT.create(MyComponentUiBinder.class);

    interface MyComponentUiBinder extends UiBinder<Widget, MyComponent> {}

    @UiField
    FlowPanel main;

    public MyComponent() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void add(Widget w) {
        main.add(w);
    }

    @Override
    public void clear() {
        main.clear();
    }

    @Override
    public Iterator<Widget> iterator() {
        return main.iterator();
    } 

    @Override
    public boolean remove(Widget w) {
        return main.remove(w);
    }
}