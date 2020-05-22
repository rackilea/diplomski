AddTableMenuItem.addActionListener(new ActionListener() 
    {
                //This method will be called whenever you click the button. 
            public void actionPerformed(ActionEvent e){
               Table table=new Table();

              JTable.setName("Table"+count);

              AddT(table);                               // Table List 
    }