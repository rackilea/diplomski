class Controller implements ActionListener {

    Panel panel;

    public Controller(Panel panel) {
        this.panel = panel;
        panel.btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("working");
    }
}