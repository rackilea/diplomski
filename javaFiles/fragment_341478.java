private void addCnctButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

    AddConnectionPanel panel = new AddConnectionPanel();
    panel.setConnectionPanelListener(new ConnectionPanelListener(){

        @Override
        void onOkButtonClicked(String... options){ TODO: fill sPanel using the given Strings }

        @Override
        void onCancelButtonClicked(){ TODO }
    });

    topFrame.setContentPane(panel);
    topFrame.invalidate();
    topFrame.validate();
}