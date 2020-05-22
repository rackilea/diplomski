Frame02 frame2 = new Frame02();
frame2.addWindowListener(new WindowAdapter() {

    @Override
    public void windowClosed(WindowEvent we) {

        Frame02 frame2 = (Frame02) we.getWindow();
        jTextField1.setText(frame2.getText());

        toFront();
        jTextField1.requestFocusInWindow();

    }

});

frame2.setVisible(true);
frame2.toFront();
frame2.requestFocus();