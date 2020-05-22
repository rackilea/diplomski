import org.nlogo.headless.*;
import org.nlogo.api.*;
class J {
   public static void main(String[] args) {
      try {
         HeadlessWorkspace ws = HeadlessWorkspace.newInstance();
         ws.openString(org.nlogo.util.Utils.url2String("/system/empty.nlogo"));
         ws.command("cro 8 [ fd 5 ]");
         org.nlogo.api.Turtle turtle =(org.nlogo.api.Turtle) ws.world().turtles().agent(3);
         System.out.println("[xcor] of turtle 3 = " + turtle.xcor());
         ws.dispose();
      }
      catch(Exception ex) {
         ex.printStackTrace();
      }
   }
}