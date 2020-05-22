Container cp=getContentPane(); 
JButton button = new JButton(new ActListaAng("Action"));
button.setText("Open");
cp.add(button, BorderLayout.PAGE_START);
cp.add(panouPrinc);
pack();