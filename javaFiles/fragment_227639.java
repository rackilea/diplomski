public void actionPerformed(ActionEvent e) { 
    if (q==2) {
        label2.setText("Correct!"); 
    } else {
        label2.setText("Wrong!!");
    }

    if(e.getSource() instanceof JButton) {
        ((JButton)e.getSource()).setEnabled(false);
    }
}