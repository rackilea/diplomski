portsettings.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           JDialog dialog = new JDialog(frame);
           dialog.add(PortSettings);
           dialog.pack();
           dialog.setVisible(true);
       }
   });