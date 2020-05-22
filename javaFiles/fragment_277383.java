public void onSectionAttached(int number) {
switch (number) {
    case 1:
        mTitle = getString(R.string.home);
        break;
    case 2:
        mTitle = getString(R.string.academics);
        break;
    case 3:
        mTitle = getString(R.string.about);
        break;
    case 4:
        mTitle = getString(R.string.student);
        break;
    case 5:
        mTitle = getString(R.string.alumni);
        break;
    case 6:
        mTitle = getString(R.string.events);
        break;
    case 7:
        mTitle = getString(R.string.media);
        break;
    case 8:
        mTitle = getString(R.string.contact);
        break;
    }
    setTitle();
}

private void setTitle() {
    getSupportActionBar().setTitle(mTitle);
}