public static class SortDialogFragment extends SherlockDialogFragment {
    private MyAdapter mAdapter;
    public static SortDialogFragment newInstance(ArrayList<MyObject> objectsToSort, MyAdapter adapter) {
        SortDialogFragment sortDialog = new SortDialogFragment();
        sortDialog.setAdapter(adapter);
        Bundle args = new Bundle();
        args.putParcelableArrayList("MyObjects to sort", objectsToSort);
        sortDialog.setArguments(args);
        return sortDialog;
    }

    public void setAdapter (MyAdapter adapter){
         mAdapter = adapter;
    }
   (...)