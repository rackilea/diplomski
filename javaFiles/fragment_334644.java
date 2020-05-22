private void buildSelectedBookPanel(){

       selectedBookPanel = new JPanel();
       selectedBookList = new JList(selectedBooks);
       selectedBookList.setVisibleRowCount(7);

       JScrollPane selectedMonthScrollPane = new JScrollPane(selectedBookList);

       selectedBookPanel.add(selectedMonthScrollPane);
   }