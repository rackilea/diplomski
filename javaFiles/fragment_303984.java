public class friendjava extends Fragment {

    private View view;
    private ListView list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.friends, container, false);


        list = view.findViewById(R.id.listview1);

        final ArrayList<String> mylist = new ArrayList<>();
        mylist.add("wisdom");
        mylist.add("favour");
        mylist.add("faith");
        mylist.add("chisom");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mylist);

        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),mylist.get(position),Toast.LENGTH_SHORT).show();

            }
        });

    }

   return view;
}