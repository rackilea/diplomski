import javax.swing.*;

public class HelloWorld extends JFrame{

 public static void main(String[] args) {

          SwingUtilities.invokeLater(new Runnable() {
          public void run() {
          new HelloWorld().setVisible(true);
        }
    });

     }
    public  HelloWorld()
    {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hello World Button App");

        panel pan= new panel();
        add(pan.panel);
        pack();
        setVisible(true);
    }
   }

   class panel {

      private JButton btn1 = new JButton("Klick!");
      private JTextField txt1 = new JTextField(10);
      private JTextField txt2 = new JTextField(10);
      JPanel panel;
      public panel() {
           panel = new JPanel();
           panel.add(btn1);
           panel.add(txt1);
           panel.add(txt2);
        }
      }