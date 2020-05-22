public class TextDialog extends Dialog implements ActionListener {

    private static final long serialVersionUID = 1L;
    private boolean dialogCompleted = false;
    private Button ok, can;
    private TextField input;

    public TextDialog() {

        super(new Frame(""), "Text dialog", true);
        setLayout(new FlowLayout());
        input = new TextField(15);                                
        add(new Label("Input :"));
        add(input);                
        addOKCancelPanel();
        createFrame();
        pack();
        setVisible(true);
    }

    private void addOKCancelPanel() {

        Panel p = new Panel();
        p.setLayout(new FlowLayout());
        createButtons(p);
        add(p);
    }

    private void createButtons(Panel p) {

        p.add(ok = new Button("OK"));
        ok.addActionListener(this);
        p.add(can = new Button("Cancel"));
        can.addActionListener(this);
    }

    private void createFrame() {

        Dimension d = getToolkit().getScreenSize();
        setLocation(d.width / 4, d.height / 3);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == ok) {

            dialogCompleted = true;
            setVisible(false);
        } else if (ae.getSource() == can) {

            dialogCompleted = false;
            setVisible(false);
        }
    }

    public boolean isDialogCompleted() {
        return dialogCompleted;
    }

    public String getInput() {
        return input.getText();
    }     
}