public class MyController implements ActionListener {
    private MyView view;
    private MyModel model;

    MyController(MyModel theModel){
        model = theModel;
        view = new MyView(this);
        model.register(view);
    }

    // implement actionPerformed here
}