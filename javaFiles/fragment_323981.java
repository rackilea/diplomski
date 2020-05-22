public boolean onKeyDown(int keyCode, KeyEvent event) {
    switch (keyCode) {
        case KeyEvent.KEYCODE_BACK:
            Intent i = new Intent();
            i.putExtra(PERSON_ID_EXTRA, getPersonId());
            i.putParcelableArrayListExtra(PERSON_CONTACT_LIST, (ArrayList<? extends Parcelable>) contactFriends);
            getActivity().setResult(Activity.RESULT_OK, i);
            finish();
            return true;
    }
    return false;
}