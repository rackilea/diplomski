@AfterViews
void initViews() { // you can put it in OnCreate()
        imageButtonList.setTag(0);
    imageButtonGroup.setTag(1);
    imageButtonProfile.setTag(2);
    mMainPagerAdapter.addTab(imageButton1, Fragment1_.class, null);
    mMainPagerAdapter.addTab(imageButton2, Fragment2_.class, null);
    mMainPagerAdapter.addTab(imageButton3, Fragment3_.class, null);
}