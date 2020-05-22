for(int i = 0; i<b.size(); i++) {
    Book temp = b.bookshelf.get(i);
    if(temp instanceof Dictionary){
        b.bookshelf.remove(temp);
        b.bookshelf.add(size - 1, temp);
    }
}