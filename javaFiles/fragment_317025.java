@Override
public void onItemSelected(String id) {
        Bundle arguments = new Bundle();
        arguments.putString(MasterListFragment.ARG_ITEM_ID, id);
        MasterListFragment fragment = new MasterListFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.item_detail_container, fragment).commit();

}