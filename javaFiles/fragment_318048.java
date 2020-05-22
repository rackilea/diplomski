public void addFrag(Fragment fragment, String title) {
    Bundle bundle = new Bundle();
    //important line here to note
    bundle.putString("email", emailAddress);

    fragment.setArguments(bundle);
    mFragmentList.add(fragment);
    mFragmentTitleList.add(title);
}