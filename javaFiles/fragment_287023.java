public void actionPerformed(ActionEvent event) {
    jlabel.setText("Good job!");
    jpanel.remove(jbutton);
    jpanel.revalidate();
    jpanel.repaint();
}