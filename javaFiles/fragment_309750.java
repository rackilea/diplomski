JButton okButton = new JButton("OK");  
       okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JComboBox jComboBox1 = (JComboBox) e.getSource();
            Item item = (Item) jComboBox1.getSelectedItem();
            String code = (String) item.getValue();
            System.out.println(code);
         }          
      });