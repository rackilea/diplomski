mSCA = new SimpleCursorAdapter(this,
            android.R.layout.simple_expandable_list_item_2, //<<<< layout
            dbhlpr.getAllPeople(), //<<<< Cursor (grabbed directly)
            new String[]{
                    DBHelperPeople.FORENAME_COL, //<<<< Column(a) to show
                    DBHelperPeople.SURNAME_COL}, //<<<< Column(b) to show
            new int[]{
                    android.R.id.text1,  //<<<< view for (a)
                    android.R.id.text2}, //<<<< view for (b)
            0
    );
    mLV1.setAdapter(mSCA);