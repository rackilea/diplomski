class DialogWithoutExtend {

    private JFrame frame;
    public DialogWithoutExtend(JFrame frame) {
        this.frame = frame;
    }

    public void cretaUI() {
        JDialog dialog = new JDialog(frame);
        dialog.setTitle("Dialog created without extending JDialog class.");
        dialog.setSize(new Dimension(400, 100));
        dialog.setLocationRelativeTo(frame);
        dialog.setModal(true);
        dialog.setVisible(true);
    }
}