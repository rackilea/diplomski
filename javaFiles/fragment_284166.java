public static void setTab(int i){
    if(i==0){
        mTabHost.setCurrentTab(i+1);
        mTabHost.setCurrentTab(i);
    }
    else{
        mTabHost.setCurrentTab(i-1);
        mTabHost.setCurrentTab(i);
    }
}