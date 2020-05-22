public class TestSwingWorkerDialog {

    public static void main(String[] args) {
        new TestSwingWorkerDialog();
    }
    private JDialog dialog;

    public TestSwingWorkerDialog() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                MyWorker worker = new MyWorker();
                worker.execute();

            }
        });
    }

    public class MyWorker extends SwingWorker<Object, Object> {

        @Override
        protected Object doInBackground() throws Exception {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    getDialog().setVisible(true);
                }
            });
            Thread.sleep(2000);

            return null;
        }

        @Override
        protected void done() {
            System.out.println("now in done...");
            JDialog dialog = getDialog();
            // Don't care, dismiss the dialog
            dialog.setVisible(false);
        }

    }

    protected JDialog getDialog() {
        if (dialog == null) {

            dialog = new JDialog();
            dialog.setModal(true);
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            dialog.setLayout(new BorderLayout());
            dialog.add(new JLabel("Please wait..."));
            dialog.setSize(200, 200);
            dialog.setLocationRelativeTo(null);

        }

        return dialog;
    }

}