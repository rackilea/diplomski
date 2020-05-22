jcomeau@intrepid:/tmp$ cat Temp.java; java Temp
import java.awt.*;
class Temp extends java.awt.Frame
{
Frame f = new Frame(); // error is coming in this line 
// code//
public static void main(String[] args) {
 System.out.println("this is a " + new Temp());
}
}
this is a Temp[frame0,0,0,0x0,invalid,hidden,layout=java.awt.BorderLayout,title=,resizable,normal]