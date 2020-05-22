JPanel mainPanel = new JPanel(); //This would be the base panel of your UI
JPanel p1=new JPanel();
JPanel p2=new JPanel();
JPanel p3=new JPanel();
JPanel p4=new JPanel();
JPanel newPanel = new JPanel();
newPanel.add(p1);
newPanel.add(p2);
newPanel.add(p3);
newPanel.add(p4);
JScrollPane pane = new JScrollPane(newPanel);
mainPanel.add(pane);