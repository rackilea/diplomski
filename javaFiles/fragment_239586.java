import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HospitalChargesCalculator extends JFrame implements ActionListener{

private JLabel hospitalStayLabel;
private JLabel medicationLabel;
private JLabel surgicalFeesLabel;
private JLabel labFeesLabel;
private JLabel rehabLabel;
private JLabel totalLabel;

private JTextField hospitalStayTF;
private JTextField medicationTF;
private JTextField surgicalFeesTF;
private JTextField labFeesTF;
private JTextField rehabTF;

private JTextArea totalChargesTA;

private JButton calculateB;
private JButton exitB;

public static final int WIDTH = 500;
public static final int HEIGHT = 350;


int totalDays;
int totalMedication;
int totalSurgical;
int totalLab;
int totalRehab;

public HospitalChargesCalculator() {
setTitle("Hospital Charges");
Container c = getContentPane();
setSize(WIDTH, HEIGHT);

c.setLayout(null);

hospitalStayLabel = new JLabel(" Number of days spent in hospital: ",
        SwingConstants.LEFT);
medicationLabel = new JLabel(" Total Medication Charges: ",
        SwingConstants.LEFT);
surgicalFeesLabel = new JLabel(" Total sugical charges : ",
        SwingConstants.LEFT);
labFeesLabel = new JLabel(" Total lab fees: ",
        SwingConstants.LEFT);
rehabLabel = new JLabel(" Total Rehab charges: ",
        SwingConstants.LEFT);
totalLabel = new JLabel(" Total Charges: ",
        SwingConstants.LEFT);

calculateB = new JButton("Calculate");
calculateB.addActionListener(this);
exitB = new JButton("Exit");
exitB.addActionListener(this);


hospitalStayTF = new JTextField();
medicationTF = new JTextField();
surgicalFeesTF = new JTextField();
labFeesTF = new JTextField();
rehabTF = new JTextField();


totalChargesTA = new JTextArea();

hospitalStayLabel.setSize(250, 30);
hospitalStayTF.setSize(200, 30);
medicationLabel.setSize(200, 30);
medicationTF.setSize(200, 30);
surgicalFeesLabel.setSize(200, 30);
surgicalFeesTF.setSize(200, 30);
labFeesLabel.setSize(200, 30);
labFeesTF.setSize(200, 30);
rehabLabel.setSize(200, 30);
rehabTF.setSize(200,30);
totalLabel.setSize(200, 30);
totalChargesTA.setSize(200,30);
calculateB.setSize(100, 30);
exitB.setSize(100, 30);

hospitalStayLabel.setLocation(30, 25);
hospitalStayTF.setLocation(250, 25);
medicationLabel.setLocation(30, 60);
medicationTF.setLocation(250, 60);
surgicalFeesLabel.setLocation(30, 95);
surgicalFeesTF.setLocation(250, 95);
labFeesLabel.setLocation(30, 130);
labFeesTF.setLocation(250, 130);
rehabLabel.setLocation(30, 165);
rehabTF.setLocation(250, 165);
totalLabel.setLocation(30, 250);
totalChargesTA.setLocation(250, 250);
calculateB.setLocation(70, 205);
exitB.setLocation(300, 205);

c.add(hospitalStayLabel);
c.add(hospitalStayTF);
c.add(medicationLabel);
c.add(medicationTF);
c.add(surgicalFeesLabel);
c.add(surgicalFeesTF);
c.add(labFeesLabel);
c.add(labFeesTF);
c.add(rehabLabel);
c.add(rehabTF);
c.add(totalLabel);
c.add(totalChargesTA);
c.add(calculateB);
c.add(exitB);

hospitalStayTF.addActionListener(this);
medicationTF.addActionListener(this);
surgicalFeesTF.addActionListener(this);
labFeesTF.addActionListener(this);
rehabTF.addActionListener(this);

setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);

}


public int CalcStayCharges()
{
int dailyCharge = 350;

int totalStayCharge = totalDays * dailyCharge;

return totalStayCharge;
}

public int CalcMiscCharges()
{
int totalMisc = (totalMedication + totalSurgical + totalLab + totalRehab);

return totalMisc;
}

public int CalcTotalCharges()
{
int totalCharges = (CalcStayCharges() + CalcMiscCharges());

return totalCharges;
}

public void actionPerformed(ActionEvent e)
{

totalDays = Integer.parseInt(hospitalStayTF.getText());
totalMedication = Integer.parseInt(medicationTF.getText());
totalSurgical = Integer.parseInt(surgicalFeesTF.getText());
totalLab = Integer.parseInt(labFeesTF.getText());
totalRehab = Integer.parseInt(rehabTF.getText());

if (e.getActionCommand().equals("Calculate"))
{
    totalChargesTA.setText(CalcTotalCharges()+"");
}
else if (e.getActionCommand().equals("Exit"))
    System.exit(0);
}

public static void main(String[] args) 
{
HospitalChargesCalculator hospCalc = new HospitalChargesCalculator();
}
}