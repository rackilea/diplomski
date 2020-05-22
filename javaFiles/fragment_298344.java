btn.addMouseListener(new MouseAdapter(){
    public void mouseDragged(MouseEvent e){
        Dimension size=btn.getPreferredSize();
        JButton button = (JButton)e.getSource();
        TransferHandler handle = button.getTransferHandler();
        handle.exportAsDrag(button, e, TransferHandler.COPY);
    }
});