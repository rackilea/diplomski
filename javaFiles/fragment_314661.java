button.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
      try {
          File newTextFile = new File("data.txt");
          FileWriter data = new FileWriter(newTextFile);
          data.write(text.getText());
          data.write(text1.getText());
          data.close();
        } 
          catch (IOException iox) {
             iox.printStackTrace();
          }
        }

    }
});