class ButtonListener implements ActionListener {
     public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button) {
                 label.setLocation(xValue, yValue);
            }
     }
}