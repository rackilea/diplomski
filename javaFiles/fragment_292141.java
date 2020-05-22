import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;

        class GUI extends Frame implements WindowListener
        {

            public GUI()
            {
                super("GUI");

                setLayout(new FlowLayout());
                addWindowListener(this);
            }

            public void windowDeiconified(WindowEvent event){}
            public void windowIconified(WindowEvent event){} 
            public void windowActivated(WindowEvent event){} 
            public void windowDeactivated(WindowEvent event){}
            public void windowOpened(WindowEvent event){} 
            public void windowClosed(WindowEvent event)  {}
            public void windowClosing(WindowEvent e) { System.exit(0); }

            public static void main(String[] args)
            {
                GUI screen = new GUI();

                screen.setSize(500,100);
                Button button1 = new Button("Button 1");
                button1.addActionListener(new ActionListener() {
                    System.out.println("It works - Button1");
                });
                screen.add(button1);
                screen.setLocationRelativeTo(null);
                screen.setVisible(true);
            }
        }