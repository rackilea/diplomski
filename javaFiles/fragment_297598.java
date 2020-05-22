import java.awt.MouseInfo;

public class ExampleMouseInfo {

     public static void main(String[] args){
         int mouseYPos = MouseInfo.getPointerInfo().getLocation().y;
         int mouseXPos = MouseInfo.getPointerInfo().getLocation().x;
         System.out.println(mouseXPos);
         System.out.println(mouseYPos);
     }
}