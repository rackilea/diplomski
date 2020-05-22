if (finalDigit > 9){
    i++;
    int newDigit = lists.theLists[10].get(i-1) + (finalDigit/10);
    lists.theLists[10].remove(i-1);
    lists.theLists[10].add(i-1,newDigit);
    finalDigit %= 10;
    for (int j=(i-1); j>=0; j--){
        if (lists.theLists[10].get(j) > 9){
            if (j == 0){
                lists.theLists[10].add(j,0);
                j++;
                i++;
            }
            newDigit = lists.theLists[10].get(j-1) + 1;
            lists.theLists[10].remove(j-1);
            lists.theLists[10].add(j-1,newDigit);
            newDigit = lists.theLists[10].get(j) % 10;
            lists.theLists[10].remove(j);
            lists.theLists[10].add(j,newDigit);
        }
    }
    i--;
}