public class LoadObjects extends ListFragment 
{

    String data[] = new String[] { "one", "two", "three", "four" };
    public ArrayAdapter<String> mAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                data);
        setListAdapter(mAdapter);
    }
}