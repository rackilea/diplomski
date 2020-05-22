for (int i = 0; i < totalbooks; i++) {
    if(title.equals(books[i].getTitle())) {
        return quantity <= books[i].getQuantity();
    }
}
return false;