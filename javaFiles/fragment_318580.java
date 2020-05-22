// FragmentTransaction boilerfluff here
DialogFragment newFragment = MyDialogFragment.newInstance(new MyDialogFragment.Callback() {
    @Override
    public void onResult(String result) {
        // Do stuff
    }
});
newFragment.show(ft, "dialog");