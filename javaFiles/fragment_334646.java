private class removeButton implements ActionListener
   {
       @Override
        public void actionPerformed(ActionEvent e)
        {

           for(Object book : selectedBookList.getSelectedValues())
           {
                books.addElement(book.toString());
                selectedBooks.removeElement(book);
           }



        }

   }