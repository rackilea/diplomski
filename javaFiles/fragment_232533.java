public interface AddController {
    public DataModel getModel();
    public AddView getView();
}

public class AbstractAddController implements AddController {

    private AddView view;
    private DataModel model;

    public AbstractAddController(AddView view, DataModel model) {
        this.view = view;
        this.model = model;

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getModel().add();
            }
        });

        model.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                getView().setData(getModel().getData());
            }
        });
    }

    @Override
    public DataModel getModel() {
        return model;
    }

    @Override
    public AddView getView() {
        return view;
    }

}

public class DefaultAddController extends AbstractAddController {

    public DefaultAddController(AddView view, DataModel model) {
        super(view, model);
    }

}