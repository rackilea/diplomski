import javax.swing.*
public class MyDrawPanel{
     public static void main(String... args)
     {
         JFrame frame = new JFrame(200,200);//A window with 200x200 pixel
         MyDrawPanel mdp = new MyDrawPanel();//Panel instance
         frame.add(mdp);//Add the panel to the window
         frame.setVisible(true);//Display all
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit when the window is closed

     }
}