JButton button = new JButton(" Method A");
    //Add action listener to button
    button.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e)
        {
            //Execute when button is pressed
            methodB();
        }
    });