JButton [] seats = new JButton [40]; //creating a pointer to the buttonsArray
    for (int i = 0; i < 40; i++)
    {
        seats[i] = new JButton();//creating the buttons
        seats[i].setPreferredSize(new Dimension(50,25));//button width
        panel4seating.add(seats[i]);//adding the buttons to the panels
        final int ii = i;  // Create a local final variable ...
        seats[i].addActionListener(new ActionListener()
         {  //anonymous inner class
            public void actionPerformed(ActionEvent evt)
            {  
                String firstName = (String)JOptionPane.showInputDialog("Enter First Name");
                String lastName = (String)JOptionPane.showInputDialog("Enter Last Name");

                sw101.AddPassenger(firstName, lastName, ii);
            }
         });
    }