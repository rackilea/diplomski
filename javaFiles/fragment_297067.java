public class LabFiveOne
{

public static void main(String[] args)
    {   
    JFrame frame = new JFrame("String Equality Program");

    final JTextField tf1 = new JTextField(10);
    tf1.setActionCommand(tf1.toString());
    tfListener tfListen = new tfListener(tf1);
    final JTextField tf2 = new JTextField(10);
    tf2.setActionCommand(tf2.toString());
    JButton chEq = new JButton("Check Equality");  
    chEq.addActionListener(tfListen);


    JPanel nPanel = new JPanel();
    nPanel.add(tf1);
    nPanel.add(tf2);
    frame.add(nPanel, BorderLayout.NORTH);
    JPanel sPanel = new JPanel();
    sPanel.add(chEq);
    frame.add(sPanel, BorderLayout.SOUTH);
    nPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    frame.pack();

    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}