class AnonymousActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        lblNylabel.setText("New label text");
   }
}

btnNewButton.addActionListener(new AnonymousActionListener());