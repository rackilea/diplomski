JPanel jPanel1 = new JPanel();
jPanel1.setLayout(new java.awt.BorderLayout());
 ..
ChartPanel CP = new ChartPanel(chart);
.. 
jPanel1.add(CP,BorderLayout.CENTER);
jPanel1.validate();