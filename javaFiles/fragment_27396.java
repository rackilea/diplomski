class MySpecialPanel extends JPanel {

    public MySpecialPanel() {

        JButton button = new JButton( new AbstractAction("Show") {
            public void actionPerformed(ActionEvent event) {
                JDialog dialog = new JDialog( (Window)getTopLevelAncestor(), "Some Title", Dialog.ModalityType.DOCUMENT_MODAL );
                dialog.add( new DialogPanel() );
                dialog.show();
            }
        });
    }
}