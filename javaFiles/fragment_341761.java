final Gui frame = new Gui();
frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// <- prevent closing
frame.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        frame.setExtendedState(JFrame.ICONIFIED);
    }
});

frame.setSize(200,200);
frame.setVisible(true);