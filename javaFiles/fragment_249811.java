public class App {
    int x1 = 0;           //<<<<<<------change your variable names
    int y1 = 140;
    int x2 = 120;
    int y2 = 140;
    int x3 = 60;
    int y3 =0;

public static void main(String[] args) 
     { 

       App app = new App();     //instantiate an instance
      app.paint(g);   //dunno where you get g, but paint needs to be its own method.




    }

   public void paint (Graphics page)
               {

                  page.drawLine (1x, 1y, 2x, 2y); 
                  page.drawLine (2x, 2y, 3x, 3y);
                  page.drawLine (3x, 3y, 1x, 1y); 

               }
}