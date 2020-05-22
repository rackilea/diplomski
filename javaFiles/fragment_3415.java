public class ActionHandler implements ActionListener {

    private JButton master;

    public ActionHandler(JButton master) {
        this.master = master;
    }

    protected void setText(String text) {
        master.setText(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String text = null;

        count++;
        if (count / 2f == Math.round(count / 2f)) {
            text = "O";
        } else {
            text = "X";
        }

        setText(text);

    }

}