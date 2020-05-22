length = myItems.size();

    String[] mStrings = new String[myItems.size()];
    String[] stadtStrings = new String[myItems.size()];
    shouldBeHidden = new boolean[length];
    for(int i=0;i<myItems.size();i++) {
        mStrings[i] = myItems.get(i).getkfz();
        stadtStrings[i] = myItems.get(i).getStadt();
        shouldBeHidden[i] = true;
    }