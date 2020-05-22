frame.addWindowListener(new WindowAdapter() {
    public void windowClosed(WindowEvent e) {
         MyJFrame frame = (MyJFrame) e.getSource();
         frame.someTextField.setText("");
         ...
    }
});