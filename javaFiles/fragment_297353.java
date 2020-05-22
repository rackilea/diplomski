public class GUI {
    private JFrame frame = new JFrame();
    private DefaultTableModel model = new DefaultTableModel();
    private JTable table = new JTable(model);
    private JScrollPane pane = new JScrollPane(table);

    public GUI() {
        model.addColumn("Name");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.pack();
        frame.setVisible(true);
    }

    public void addRow(String name) {
        model.addRow(new Object[] { name });
    }

    /**
     * Controller is a SwingWorker.
     */
    public static class Controller extends SwingWorker<Void, String> {
        private GUI gui;

        private List<String> pending;

        public Controller() {
            gui = new GUI();
        }

        public void doWork(String newLine) {
            if (pending == null) {
                pending = new ArrayList<String>();
                pending.add(newLine);
                execute();
            } else {
                pending.add(newLine);
            }
        }

        @Override
        protected Void doInBackground() throws Exception {
            while (pending.size() > 0) {
                publish(pending.remove(0));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        /**
         * @inherited <p>
         */
        @Override
        protected void process(List<String> chunks) {
            for (String object : chunks) {
                gui.addRow(object);
            }
        }

    }

    /** 
     * Simulating the adapter.
     * 
     *  Obviously, the real-thingy wouldn't have a reference 
     *  to the controller, but message the doWork refectively 
     */
    public static class Adapter implements Runnable {

        Controller controller;

        public Adapter(Controller controller) {
            this.controller = controller;
        }

        @Override
        public void run() {
            for (int i=0; i<10; i++)
            {
                controller.doWork("Line "+(i+1));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void main(String[] args)
    {
        System.err.println("Initializing controller");
        new Adapter(new Controller()).run();
    }

    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(GUI.class.getName());
}