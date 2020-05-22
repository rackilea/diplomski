//  ArrayAdapter with Person[] as source
    //      built within DBHelperPeople getAllPeopleAsPersonArray
    mPeople = dbhlpr.getAllPeopleAsPersonArray();
    mAAPeeople = new ArrayAdapter<Person>(this,
            android.R.layout.simple_expandable_list_item_1,
            mPeople
    );
    mLV3.setAdapter(mAAPeeople);