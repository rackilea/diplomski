import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class foo extends JPanel
{  
  public foo()
  {
    final JMenu edit = new JMenu();
    edit.getItem(0).addMouseListener(new MouseAdapter(){ 
    @Override
        public void mouseClicked(MouseEvent e) 
        {
            if (e.getClickCount() == 1) {
                edit.getItem(0).setEnabled(true);
            }
        } 
    });
  }
}