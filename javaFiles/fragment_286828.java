//This is needed if you want "operations" to be accessible on its own
@Route(value = "operations",layout = MainView.class)
@ParentLayout(MainView.class)
public class OperationsView extends VerticalLayout implements RouterLayout {

    Div content=new Div();
    public OperationsView(){
        System.out.println("operations view");
        add(new Label("operations view"));
        add(content);
    }
}