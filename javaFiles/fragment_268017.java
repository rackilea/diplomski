public void removeBook() {
    int i=Integer.parseInt(JOptionPane.showInputDialog("Pleanse input isbn to be removed"));
    Iterator<Book> b=books.iterator();
    while(b.hasNext()) {
        if(i == b.next().ISBN)
            b.remove();
    }
}