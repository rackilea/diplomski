listViewDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        toolbar.setTitle(getResources().getString(R.string.title));

        fragmentMain = new FragmentMain();

        android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                   .replace(R.id.frameLayoutMain, ApplicationTapaKiosk.getInstance().fragmentMain)
                   .commit();

        fragmentManager.executePendingTransactions(); // wait for the transaction to finish
        drawerLayout.closeDrawer(listViewDrawer); // call closeDrawer(...) as a last thing
    }
 }