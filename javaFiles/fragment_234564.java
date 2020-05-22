for (int i = 0; i < customerList.size(); i++) {
    int sum = 0;

    for (int j = 0; j < bookList.size(); i++) {  
        if (i == index) {
            dotProduct.add(0);
        } else { //Next line is line 72.
            sum = sum + (pureRatingsList.get(index).get(j)) * (pureRatingsList.get(i).get(j)); //Line 72.
        }
    }
    dotProduct.add(sum);
}