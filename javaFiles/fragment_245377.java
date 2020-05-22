public class MyPanel extends JPanel{
   public MyPanel(){
      super.setSize(500,500);
      super.setVisible(true);

   }
   @Override
   public void paint(Graphics g){
       for(int i = 0; i < 6; i++){
           for(int j = 0; j < 6; j++){
               g.drawImage(theImage,i*10,j*10,null);// the tens are your image's dimensions. If your image is 100x50 then it must be i*100 and j*50
           }
       }
   }
}