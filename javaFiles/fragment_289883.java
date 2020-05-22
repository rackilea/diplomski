private class MyListener implements ActionListener {
    ArrayList<Book> book = new ArrayList<>();
    int displayedBook = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        String isbnTF, titleTF;
        int priceTF = 0;
        Book b = null;
        Object op = e.getSource();
        if (op.equals(addButton)) {
            isbnTF = t1.getText();
            titleTF = t2.getText();
            try {
                priceTF = Integer.parseInt(t3.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input! ");
            }
            b = new Book(isbnTF, titleTF, priceTF);
            book.add(b);
            t1.setText("");
            t2.setText("");
            t3.setText("");
            System.out.println(b);
        } else if (op.equals(nextButton)) {
           if(book.size()>0){
               if(displayedBook >= book.size()){
                  displayedBook = 0;
               }
               b = book.get(displayedBook);
               t1.setText(b.getIsbn());
               t2.setText(b.getTitle());
               t3.setText(b.getPrice()+" ");
               displayedBook++;
           }
        }
    }
}
}