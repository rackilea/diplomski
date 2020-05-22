public JPanel createOscPanel(final Osc o)
 {
   JPanel cbPanel = new JPanel(); 
   final String[] comboItems = {"Sine", "Custom", "FSaw", "FSquare"};
   JComboBox cb = new JComboBox(comboItems);
   cbPanel.add(cb); 

   cb.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e) {
           JComboBox cb = (JComboBox)e.getSource();
           int value = cb.getSelectedIndex();
           o.setWaveType();
           System.out.println(value); 
      } 
    });
  return cbPanel; 
 }