public class SubtractAdd extends JApplet implements ActionListener {

    public void init() {

        add = new JButton ("Add");
        add.addActionListener (this);
        subtract = new JButton ("Subtract");
        subtract.addActionListener(this);

    }

    @Override
    public void actionPerformed (ActionEvent event) {
        Object source = event.getSource();
        if (source == add) {
            label.setText("Number: " + (++num));
        } else if (source == subtract) {
            label.setText("Number: " + (--num));
        }
    });