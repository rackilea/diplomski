import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//added this line
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
public class CalcFrame extends JFrame implements ActionListener{

  private JTextField calcTextField;
  private ScriptEngineManager sem;
  private ScriptEngine scriptEngine;
  public CalcFrame(){

    super("Calculator");
    setLayout(new FlowLayout() );
    calcTextField = new JTextField (19);
    calcTextField.setPreferredSize(new Dimension(0,50));//added this line
    add (calcTextField);
    calcTextField.setEditable(false);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout ( new GridLayout(5,4,10,10) );

    String[] buttonNames = {"7", "8", "9", "/",
                            "4", "5", "6", "*",
                            "1", "2", "3", "-",
                            "0", ".", "=", "+",
                            "C", "(", ")"};

    for (String buttonText : buttonNames)
    {
        JButton button = new JButton(buttonText);
        buttonPanel.add(button);
        button.addActionListener(this);//added this line
    }

    buttonPanel.setPreferredSize(new Dimension(220, 250));
    add(buttonPanel);

    sem = new ScriptEngineManager();
    scriptEngine = sem.getEngineByName("JavaScript");

}
//added this method (it must be added because you implemented
//ActionListener above while declaring the class
@Override
public void actionPerformed(ActionEvent ev){
    JButton b = (JButton)ev.getSource();
    if(b.getText().equals("C"))
        calcTextField.setText("");
    else if(!b.getText().equals("="))
        calcTextField.setText(calcTextField.getText()+b.getText());
    else{
          try{
            String result = scriptEngine.eval(calcTextField.getText()).toString();
            calcTextField.setText(result);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"The Expression is wrong, maybe you miss a bracket!");
        }
    }
}
//-----
public static void main (String[]args) {
    CalcFrame myCalc = new CalcFrame();
    myCalc.setSize(300, 350);
    myCalc.setVisible( true );
    myCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
}