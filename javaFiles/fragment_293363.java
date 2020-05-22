List<Integer> mIds = new ArrayList<Integer>();
    mIds.add(0,10);
    mIds.add(1,10);
    mIds.add(2, 10);

    int j=-1;
    for (int i=0; i < mIds.size(); i++){
        if (mIds.get(i) == 10){ // 0th element is 10
            j=i; //then j=0
            break; // breaks the for loop
        }
    }
    if (j != -1){ // j=0 and this is true
        mIds.remove(j); // now 0th element will remove
    }