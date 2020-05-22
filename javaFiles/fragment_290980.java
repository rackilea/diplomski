//this throws exception without try catch         
 try
 {           
     ImageIcon a = new ImageIcon(this.getClass().getResource("../Card/AtlanticAve.jpg"));
     atlantic = a.getImage();        
 }        
 catch(NullPointerException e){}