public Fragment getItem(int position) {
    switch (position) {
        case 0:
            UserProfileData tab1 = new UserProfileData();
            return tab1;
        case 1:
            UserProfileCollections tab2 = new UserProfileCollections();
            return tab2;
        case 2:
            UserProfileBalance tab3 = new UserProfileBalance();
            return tab3;
        default:
            return null;
    }
}