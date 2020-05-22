JButton createButton(){
    ActionListener al = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        // run code;
      }
    };       
    JButton button = new JButton();

    button.setBounds(130, 100, 100, 40); 
    button.setText("aaa");
    button.setSize(100, 40);
    button.addActionListener(al);
    frame.add(button);

    return button;       
}