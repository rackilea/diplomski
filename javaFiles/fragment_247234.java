public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    if(command == "Panel1")
    {
        changePanel(panel1);
    }
    if(command =="Panel2")
    {
        changePanel(panel2);
    }

   }

 }