private void buildBookPanel(){

       bookPanel = new JPanel();

       books.addElement("I Did It Your Way");
       books.addElement("The History of Scotland");
       books.addElement("Another book name");

       bookList = new JList(books);

       bookList.setSelectionMode(
       ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

       bookList.setVisibleRowCount(7);

       // Add the list to a scroll pane.
      JScrollPane monthListScrollPane = new JScrollPane(bookList);

      // Add the scroll pane to the panel.
      bookPanel.add(monthListScrollPane);
   }