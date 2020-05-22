@Route(value="operation1",layout = OperationsView.class)
@RoutePrefix("operations")
public class Operation1View extends VerticalLayout {

    public Operation1View(){
        add(new Label("Operations view"));
    }
}