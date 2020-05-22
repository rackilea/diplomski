for (int i = 1; i <= books.size() - 1; i++){
    if ((books.get(i) + books.get(i + 1)) < minValue){
        index = i;
        minValue = books.get(i) + books.get(i + 1);
    }
}