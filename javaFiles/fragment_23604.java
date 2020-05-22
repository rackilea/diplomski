public static void createFramePERIOD7() {

   //Creates Panel + Buttons
   JPanel P7_Panel = new JPanel();
   JButton Column = new JButton("Add Columns");
   JButton Insert = new JButton("Insert Student 7");
   JButton Back = new JButton("Home");
   Period7 = new JFrame(); //<-------------------------- Insert this line
   //Adding Buttons and Layout to Period 7 Frame
   Period7.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   Period7.setBounds(550,200,1000,600);
   Period7.setLayout(new FlowLayout());        
   Period7.add(Back);
   Period7.add(Column);
   Period7.add(Insert);
   //Add ActionListener to Buttons
   Back.addActionListener(new GUI());
   Insert.addActionListener(new GUI());
   Column.addActionListener(new GUI());
   //Adding Panel to Frame
   //Period7.add(P7_Panel);
   Period7.setVisible(true);
   }