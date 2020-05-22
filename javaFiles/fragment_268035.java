int i = 0;
    mArrayList.clear(); //Clear your array list before adding new data in it
    for (String name : mNames) {
        Data data = new Data(name, mPrices[i], mImages[i]);
        mArrayList.add(data);
        i++;
    }