public class FragmentA extends Fragment implements OnItemClickListener {
    ListView list;
    Communicator comm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.fragment_layout_a, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        list = (ListView) getActivity().findViewById(R.id.listView1);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.titles, android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

        Log.d("this", "Done setting listview");
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub
         Intent i = new Intent(FragmentA.this.getActivity(), AnotherActivity.class);
         i.putExtra("index", arg2);
         startActivity(i);
    }

    void setCommunicator(Communicator c) {
        comm = c;
    }

    public interface Communicator {
        public void respone(int index);
    }
}