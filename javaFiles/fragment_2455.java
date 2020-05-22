import java.awt.*;
      import javax.swing.*;
      import java.util.*;
      import java.awt.event.*;
      class DiagonalLineDemo extends JFrame implements ActionListener {
      public DiagonalLineDemo()
    {
       setVisible(true);
       setSize(100,100); 
       JMenuBar s=new JMenuBar();
       JMenu m=new JMenu("Open ");
       JMenuItem s1=new JMenuItem("Dialog");
       m.add(s1);
       s.add(m);
       setJMenuBar(s);
       s1.addActionListener(this);
          }
     public void actionPerformed(ActionEvent e)
    {
        JDialog j=new JDialog(this,true);
   j.setVisible(true);
     }
        public static void main(String args[]) {
       DiagonalLineDemo f=new DiagonalLineDemo();

      }
    }