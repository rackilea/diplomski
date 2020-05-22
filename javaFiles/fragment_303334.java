button2.setAction(new AbstractAction("Process item 1") {
     private int button2Count = 2;

     @Override
     public void actionPerformed(ActionEvent evt) {
        JButton btn = (JButton) evt.getSource();
        btn.setText(makeButton2Text());
     }

     private String makeButton2Text() {
        String button2Text = "Process item " + button2Count;
        button2Count++;
        return button2Text;
     }


  });