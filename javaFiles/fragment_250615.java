public class ContactListFragment extends ListFragment {

    ArrayAdapter<Contact> cAdapter;
    //ArrayAdapter<String> cAdapter;


    interface ContactListListener{
        void itemClicked(long id);
    }
    //add listener to fragment
    private ContactListListener listener;

    public ContactListFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

    cAdapter = new ArrayAdapter<>(inflater.getContext(), simple_list_item_1, myContact);  
.....
setListAdapter(cAdapter);
        cAdapter.notifyDataSetChanged();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}