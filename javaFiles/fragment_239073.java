for (int x=0; x<10; x++){
   for (int y=0; y<10; y++){
     myButtons[x][y] = new JButton("0");
     //add to page, or do it elsewhere
     myButtons[x][y].addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
           selectionButtonPressed(x,y);
        }
     });
   }
 }