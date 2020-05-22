@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    MenuItem search = menu.findItem(R.id.action_search);
    search.setEnabled(false);
    search.setVisible(false);
    super.onCreateOptionsMenu(menu, inflater);
}