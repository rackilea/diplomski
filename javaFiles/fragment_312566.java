Print.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent ae) {
        String sourcename = SourceField1.getText();
        System.out.println("Printing in Terminal " + sourcename);

        // note change in constructor
        // this way getText() is called on the EDT.
        CounterTask1 task1 = new CounterTask1(SourceField1.getText());
        task1.execute();
     }
  });