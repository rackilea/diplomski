public class Example extends JFrame {

    BasicToolBarUI ui;

    Example() {

        JToolBar tb = new JToolBar();
        tb.add(new JButton("AAAAA"));
        tb.setBackground(Color.GREEN);
        ui = (BasicToolBarUI) tb.getUI();

        getContentPane().addContainerListener(new Listener());
        getContentPane().add(tb, BorderLayout.PAGE_START);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class Listener implements ContainerListener {

        @Override
        public void componentAdded(ContainerEvent e) {}

        @Override
        public void componentRemoved(ContainerEvent e) {

            if (ui.isFloating()) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {

                        ui.setFloating(false, null);
                    }
                }); 
            }
        }
    }

    public static void main(String[] args) {

        new Example();
    }
}