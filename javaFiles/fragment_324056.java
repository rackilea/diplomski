button.addActionListener(new ActionListener({
       public void actionPerformed(ActionEvent e)
       {
              String value = jTextBox.getText();
              // Grab the String value.
              jListModel.addElement(value);
              // And add it to the list.
       }
});