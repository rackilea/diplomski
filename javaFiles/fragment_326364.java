frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));                      
JPanel panelMain = new JPanel(new GridLayout(0,2));            
ChartPanel chartPanel = createChart();        
JPanel subPanel = new JPanel(new BorderLayout());   
subPanel.setBorder(BorderFactory.createTitledBorder("Consommation"));
subPanel.setPreferredSize(new Dimension(400, 200));    
subPanel.add(chartPanel);   


panelMain.add(subPanel);        
frame.add(panelMain);        
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);