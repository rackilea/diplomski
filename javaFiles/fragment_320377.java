public Panel11()
{
 setLayout(new BorderLayout());

 JPanel panel = new JPanel(); 
 panel.setLayout(new GridLayout(1, 2));   
 add(panel, BorderLayout.NORTH); 

 label = new JLabel("Enter an integer from 0 to 255: ");
 label.setFont(new Font("Serif", Font.BOLD, 5)); 
 label.setHorizontalAlignment(SwingConstants.LEFT); 
 panel.add(label);

 box = new JTextField("", 5); 
 box.setHorizontalAlignment(SwingConstants.RIGHT);
 panel.add(box); 

 display = new Display11();
 add(display, BorderLayout.CENTER); 

 JPanel south = new JPanel();
 south.setLayout(new FlowLayout());
 JButton button1 = new JButton("Convert");
 button1.addActionListener(new Listener1());
 south.add(button1);
 button2 = new JButton("Step");
 button2.addActionListener(new Listener2());
 south.add(button2);
 button2.setEnabled(false);
 label = new JLabel("");
 south.add(label);
 add(south, BorderLayout.SOUTH);
}