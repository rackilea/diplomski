class MyFrame extends JInternalFrame {

    private Action action;

    MyFrame(…) {
        …
        action = new AbstractAction(name) {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    MyFrame.this.setSelected(true);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public Action getAction() {
        return action;
    }
}