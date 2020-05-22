import javax.swing.ImageIcon;
import javax.swing.JButton;


public class ShapeButtons extends JButton{
static ImageIcon[] Shapes = new ImageIcon[8];
  static {
    Shapes[0] = new ImageIcon("src/images/Circle.jpg");
        Shapes[1] = new ImageIcon("src/images/Diamond.jpg");
        Shapes[2] = new ImageIcon("src/images/Square.jpg");
        Shapes[3] = new ImageIcon("src/images/rectangle.jpg");
        Shapes[4] = new ImageIcon("src/images/Ellipse.jpg");
        Shapes[5] = new ImageIcon("src/images/heart.jpg");
        Shapes[6] = new ImageIcon("src/images/star.jpg");
        Shapes[7] = new ImageIcon("src/images/triangle.jpg");
        }

public ShapeButtons(int picId){
    super ();//call the jButton cunstructor

     this.setIcon(shapes[picId]);// sets an icon the the Jbutton object.
     }

   public ShapeButtons(){
        super ();//call the jButton cunstructor            
         }

    }