abstract class Element extends JPanel {

    ...
    private final JButton button = new JButton("OK");

    protected abstract void onConfirm();

    public Element(){
        this.button.addActionListener(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) {
                onConfirm();
            }
        });
        ...
    }
}