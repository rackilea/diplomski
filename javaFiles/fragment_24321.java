public class Edytor extends JFrame{
      CObrazek obraz = new CObrazek();//here (new place)
      public static boolean pom, pom1;
        public static Image  image; 
        public static String sciezka;
        public void EdytorShow(String image_path) {//changed
            setBounds(420,50,800,600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container con = this.getContentPane();
            //CObrazek obraz = new CObrazek();//disabled
            przybornik przyb = new przybornik();//here (new place)
            /**
             * We do not want the window to appear without selecting an image.
             * For this reason we will use  "if"
             */
            if(!image_path.equals("null")){
               con.add(obraz);
           // przybornik przyb = new przybornik();//Moved out of if ;)
            pom = false;
            image = new ImageIcon(image_path).getImage();
            setVisible(true);
            }//if
        }

        public static void main(String args[]) {
           Edytor et = new Edytor();
           et.EdytorShow("null");
        }


}