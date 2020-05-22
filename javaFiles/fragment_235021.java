btn1.addActionListener(this);
btn2.addActionListener(this);

if(e.getSource()==btn1)
  setBackground(new Color(Color.GREEN));

if(e.getSource()==btn2)
  setBackground(new Color(Color.RED));