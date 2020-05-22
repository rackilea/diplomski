import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Administrador extends javax.swing.JInternalFrame {

  void showAdminWindow()
  {
    JFrame ventanaRegistro = new JFrame("Admin Window");
    ventanaRegistro.
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    ventanaRegistro.setPreferredSize(new Dimension(350, 200));
    ventanaRegistro.pack();
    ventanaRegistro.setVisible(true);
  }

  void closeThisWindow()
  {
    Window window = SwingUtilities.getWindowAncestor(this);
    window.dispose();
  }

  public Administrador()
  {

    JPanel panel = new JPanel();
    getContentPane().add(panel, BorderLayout.NORTH);

    JButton closeWindowBttn = new JButton("Close Window and open a new  one");
    closeWindowBttn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            closeWindowActionPerformed();
        }
     });
     panel.add(closeWindowBttn);
  }

  private void closeWindowActionPerformed()    {
    showAdminWindow();
    closeThisWindow();

 }

}