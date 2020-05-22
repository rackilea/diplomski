import javax.swing.*;       
    import java.awt.*;
    import java.awt.event.*;

    public class ButtonSwing {
        private int numClicks = 0;

        public Component createComponents() {
            //Method for creating the GUI componenets
            final JLabel label = new JLabel("Clicks: " + "0"); //final so that i can access inside inner class
            JButton button = new JButton("Simple Button");
            button.addActionListener(
            //inner class for ActionListener. This is how generally it is done.     
            new ActionListener() {
                           public void actionPerformed(ActionEvent e) {
                               numClicks++;
                               label.setText("Clicks: " + numClicks);
                   System.out.println(e.getActionCommand());
                   System.out.println(e.getModifiers());
                   System.out.println(e.paramString());
             }
            }
           );
            JPanel pane = new JPanel();   //using JPanel as conatiner first.
            pane.setLayout(new FlowLayout());
            pane.add(button);  // adding button to the JPanel.
            pane.add(label);   // adding label to the JPanel.
            return pane;
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("SwingApplication");
            ButtonSwing obj = new ButtonSwing();
            Component contents = obj.createComponents();
            frame.getContentPane().add(contents);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            frame.pack();  //It will cause the window to be sized to fit the preferred size 
                            //and layouts of its subcomponents. 
            frame.setVisible(true);
        }
    }