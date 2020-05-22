import java.util.List;
import javax.swing.*;

public class SwingThreadingEg extends JPanel implements MyAppendable {
    private JTextArea area = new JTextArea(30, 50);

    public SwingThreadingEg() {
        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
    }

    @Override
    public void append(String text) {
        area.append(text);
    }

    private static void createAndShowGui() {
        SwingThreadingEg mainPanel = new SwingThreadingEg();
        MyWorker myWorker = new MyWorker(mainPanel);
        // add a Prop Change listener here to listen for
        // DONE state then call get() on myWorker
        myWorker.execute();

        JFrame frame = new JFrame("SwingThreadingEg");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

class MyWorker extends SwingWorker<Void, String> {
    private static final long SLEEP_TIME = 500;
    private MyAppendable myAppendable;

    public MyWorker(MyAppendable myAppendable) {
        this.myAppendable = myAppendable;
    }

    @Override
    protected Void doInBackground() throws Exception {
        publish("Beginning Work");

        // simulate some long-running task:
        for (int i = 0; i < 20; i++) {
            publish("From SwingWorker: " + i);
            Thread.sleep(SLEEP_TIME);
        }
        publish("Finished!");
        return null;
    }

    @Override
    protected void process(List<String> chunks) {
        for (String text : chunks) {
            myAppendable.append(text + "\n");
        }
    }
}

interface MyAppendable {
    public void append(String text);
}