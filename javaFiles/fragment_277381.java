public void onSectionAttached(int number) {
    switch (number) {
        default: //Default should not be here.
        case 1:
        mTitle = getString(R.string.home);
        break;
    ...
    case 8:
        mTitle = getString(R.string.contact);
        break;
    }
}