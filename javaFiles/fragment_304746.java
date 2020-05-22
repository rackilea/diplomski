import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListSelectionGroup {

    private List<ListSelectionModel> models = new ArrayList<>();
    private MyListener myListener = new MyListener();

    public void register(ListSelectionModel model) {
        models.add(model);
        model.addListSelectionListener(myListener);
    }

    // overload method for convenience
    public void register(JTable table) {
        register(table.getSelectionModel());
    }

    // make a private inner class so that we don't accidentally add this to a 
    // ListSelectionModel without going through the register method
    private class MyListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel selectedModel = (ListSelectionModel) e.getSource();
            for (ListSelectionModel model : models) {
                if (model != selectedModel) {
                    model.removeListSelectionListener(this);
                    model.clearSelection();
                    model.addListSelectionListener(this);
                }
            }
        }
    }
}