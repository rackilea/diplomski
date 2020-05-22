Action showOptionPane = new AbstractAction("show me pane!") {

    @Override
    public void actionPerformed(ActionEvent e) {
        createCloseTimer(3).start();
        JOptionPane.showMessageDialog((Component) e.getSource(), "nothing to do!");
    }

    private Timer createCloseTimer(int seconds) {
        ActionListener close = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Window[] windows = Window.getWindows();
                for (Window window : windows) {
                    if (window instanceof JDialog) {
                        JDialog dialog = (JDialog) window;
                        if (dialog.getContentPane().getComponentCount() == 1
                            && dialog.getContentPane().getComponent(0) instanceof JOptionPane){
                            dialog.dispose();
                        }
                    }
                }

            }

        };
        Timer t = new Timer(seconds * 1000, close);
        t.setRepeats(false);
        return t;
    }
};