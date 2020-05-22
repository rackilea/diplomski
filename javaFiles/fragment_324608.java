public boolean isGoodRow( int yRowParam ){
    // for number = 1,..,9, ensure the count is not > 1
    for(int i=1; i<=9; i++)
        if(timesRowHas(yRowParam, i) > 1)
            return false;
    return true;
}