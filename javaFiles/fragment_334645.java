private void buildButtonPanel()
   {
      buttonPanel = new JPanel();
      addButton = new JButton("Get Selections");
      removeButton=new JButton("Remove Selections");
      addUpButton=new JButton("Check Out");

      addButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0)
        {

            for(Object book : bookList.getSelectedValues())
            {
                selectedBooks.addElement(book.toString());
                books.removeElement(book);
            }
        }
    });

      removeButton.addActionListener(new removeButton());
      addUpButton.addActionListener(new ButtonListener());

      buttonPanel.add(addButton);
      buttonPanel.add(removeButton);
      buttonPanel.add(addUpButton);
   }