@Override
public void actionPerformed(ActionEvent ae) {
    Object source = ae.getSource();
    if (source instanceof JButton) {
       if (ae.getText().equals("Start")) {
          ae.setText("Stop");
          // do other stuff
       } else if (ae.getText().equals("Stop")) {
          ae.setText("Start");
          // do more stuff
       }
    }
}