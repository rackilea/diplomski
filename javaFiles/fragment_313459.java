public void addFragment(Fragment fragment, String fragTitle) {

    mFragments.add(fragment);
    fragTitle = fragTitle.toLowerCase()
    fragTitle = fragTitle.substring(0, 1).toUpperCase() + fragTitle.substring(1);
    mFragmentTitleList.add(fragTitle);

}