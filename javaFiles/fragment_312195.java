import javax.swing.JButton;


public class replaceButton **extends JButton**
{
    public replaceButton(String name)
    {
         this.setText(name);
         ImageIcon background = new ImageIcon("/assets/buttons/menu.png");
         this.setIcon(background);
         this.setSize(1000,1000);
    }
}