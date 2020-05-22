image = new ImageIcon(filename);
     icon = new ImageIcon(image.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
     editorText.insertIcon(icon);
     editorText.setEditable(true); 
     editorText.setFocusable(true); 


   int point1 = 400;
   int point2 = 400;              

   ExpandImage.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e) {
         point1 +=50;
         point2 +=50;
              image = new ImageIcon(filename);
 icon = new ImageIcon(image.getImage().getScaledInstance(point1,point2,  Image.SCALE_DEFAULT));
 //
 editorText.setIcon(null) 
 //
 editorText.insertIcon(icon);
 editorText.setEditable(true); 
 editorText.setFocusable(true);


             System.out.println("You clicked me!");  
         }        
     });