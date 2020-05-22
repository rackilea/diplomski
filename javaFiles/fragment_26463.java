import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingWorker;

//gui only, unaware of logic 
public class MyView extends JFrame {

    private JList<String> loglist;
    private JButton log;

    public MyView(DefaultListModel<String> model) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        log = new JButton("Start Process");
        add(log, BorderLayout.PAGE_START);
        loglist = new JList<>(model);
        loglist.setPreferredSize(new Dimension(200,300));

        add(loglist, BorderLayout.PAGE_END);
        pack();
        setVisible(true);
    }

    void addButtonListener(ActionListener listener) {
        log.addActionListener(listener);
    }

    public static void main(String args[]) {
        new MyController();
    }
}

//represents the data (and some times logic) used by GUI
class Model {

    private DefaultListModel<String> model;

    Model() {

        model = new DefaultListModel<>();
        model.addElement("No logs yet");
    }

    DefaultListModel<String> getModel(){
        return model;
    }
}

//"wires" the GUI, model and business process 
class MyController {

    MyController(){
        Model model = new Model();
        MyBusiness business = new MyBusiness(model.getModel());
        MyView view = new MyView(model.getModel());
        view .addButtonListener(e -> business.start());
    }
}

//represents long process that needs to update GUI
class MyBusiness extends SwingWorker<Void, String>{

    private static final int NUMBER_OF_LOGS = 9;
    private int counter = 0;
    private DefaultListModel<String> model;

    public MyBusiness(DefaultListModel<String> model) {
        this.model= model;
    }

    @Override  //simulate long process 
    protected Void doInBackground() throws Exception {

        for(int i = 0; i < NUMBER_OF_LOGS; i++) {

            //Successive calls to publish are coalesced into a java.util.List, 
            //which is by process.
            publish("log message number " + counter++);
            Thread.sleep(1000);
        }

        return null;
    }

    @Override
    protected void process(List<String> logsList) {
        //process the list received from publish
        for(String element : logsList) {
            model.addElement(element);
        }
    }

    void start() { 
        model.clear(); //clear initial model content 
        super.execute();
    }
}