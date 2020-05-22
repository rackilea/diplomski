public class Frame extends JFrame
{
        JLabel lab = new JLabel("Enter Your Name :");
        JLabel lab2 = new JLabel("Enter Your Birthday :");
        JLabel lab3 = new JLabel("Enter Your Age:");
        JLabel lab4 = new JLabel("Enter Your HomeTown:");
        JLabel lab5 = new JLabel("Choose Your Department:");
        JButton b1 = new JButton("Exit");
        JTextField t1 = new JTextField(15);
        JTextField t2 = new JTextField(15);
        JTextField t3 = new JTextField(15);
        JTextField t4 = new JTextField(15);
        JButton b2 = new JButton("Submit");
        JButton b3 = new JButton("Clear");
         JLabel lab6 = new JLabel("Message :");

         Vector vector = new Vector();
        JList list = new JList(vector);

        JPanel panel = new JPanel();
        JLabel brief;

    public Frame()
    {

        setLocation(500,280);
        panel.setLayout(null);


        lab.setBounds(10,10,150,20);
        t1.setBounds(130,10,150,20);
        lab5.setBounds(10,40,150,20);
        lab2.setBounds(10,140,150,20);
        t2.setBounds(130,140,150,20);
        lab3.setBounds(10,170,150,20);
        t3.setBounds(110,170,150,20);
        lab4.setBounds(10,200,150,20);
        t4.setBounds(150,200,150,20);
        lab6.setBounds(10,240,150,20);
        list.setBounds(50,270,150,20);
        list.setSize(250,150);
        b1.setBounds(250,470,150,20);
        b2.setBounds(60,470,150,20);
        b3.setBounds(160,470,150,20);
        b1.setSize(60,30);
        b2.setSize(75,30);
        b3.setSize(65,30);


        panel.add(lab);
        panel.add(t1);
        panel.add(lab5);
        panel.add(lab2);
        panel.add(t2);
        panel.add(t3);
        panel.add(t4);
        panel.add(lab4);
        panel.add(lab3);
        panel.add(lab6);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(list);

        brief = new JLabel("Goodmorning "+t1+" Today is "+t2+" its your birthday You are now"+t3+" of age You are From"+t4);
        getContentPane().add(panel);


        b1.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent a)
           {
               Object source = a.getSource();

               if(source == b1)
               {
                   System.exit(0);
               }
           }
        });

        b2.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent a)
            {
                Object source = a.getSource();

                if(source == b2)
                {
                   vector.add(t1.getText() + "-" + t2.getText() + "-" + t3.getText() + "-" + t4.getText());
                   list.setListData(vector);                                      
                   list.revalidate();
                   list.repaint();
                }  
            }
        });
        b3.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent a)
           {
               Object source = a.getSource();

               if(source == b3)
               {
                   t1.setText("");
                   t2.setText("");
                   t3.setText("");
                   t4.setText("");
               }
           }
        });
    }       

    public static void main(String args [])
    {
        Frame w = new Frame();

        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(400,600);
        w.setVisible(true);
    }
}