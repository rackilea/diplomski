public void onCreate(Bundle savedInstanceState) {
    ...
    if (savedInstanceState != null) {
        //Restore the fragment's instance
        mContent = getSupportFragmentManager().getFragment(savedInstanceState, "myFragmentName");
        ...
    }
    ...
}

@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);

    //Save the fragment's instance
    getSupportFragmentManager().putFragment(outState, "myFragmentName", mContent);
}