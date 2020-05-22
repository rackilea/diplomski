import java.awt.BorderLayout;
    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.Font;
    import java.awt.GridBagLayout;
    import java.awt.Toolkit;

    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JPanel;


    public class weirdMath {

      public static void main(String[] args){
          double number1=Double.parseDouble(JOptionPane.showInputDialog("input a first number"));
          double number2=Double.parseDouble(JOptionPane.showInputDialog("input a second number")); 
          String operation=JOptionPane.showInputDialog("input an operation (+-/*)");
          number1*=2;number2*=2;
          double result=0;
          if(operation.equals("+")){result=number1+number2;}
          else if(operation.equals("-")){result=number1-number2;}
          else if(operation.equals("/")){result=number1/number2;}
          else if(operation.equals("*")){result=number1*number2;}
          JFrame jf=new JFrame("your answer");
          jf.setSize(300,75);
             Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
             int width = (int)screenSize.getWidth();
             int height = (int)screenSize.getHeight();
           jf.setLocation((int)(width/4.5), (int)(height/3.5));
          JLabel jlmessagepart1=new JLabel("       taking your two numbers times 2");
          JLabel jlmessagepart2=new JLabel("then performing your operation you get...");
          JLabel jlresult=new JLabel(""+result);
          jlresult.setFont(new Font(null, Font.BOLD, 20));
          jlresult.setForeground(Color.blue);
          jf.setLayout(new BorderLayout());
          jf.add(jlmessagepart1,BorderLayout.NORTH);
          jf.add(jlmessagepart2,BorderLayout.CENTER);
          jf.add(jlresult,BorderLayout.SOUTH);
          jf.setVisible(true);


      }
    }