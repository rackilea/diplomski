public class ContentFragment extends Fragment {

    ListView lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment,container,false);

        lv = (ListView) view.findViewById(R.id.resultList);

        ViewHandler viewHnd = new ViewHandler(ContentFragment.this); // add this handler for parameter of yout AsyncTask.

        String type = "home";
        homeOperation homeOperation = new homeOperation(ContentFragment.this.getActivity(), viewHnd);
        homeOperation.execute(type, "", "");


        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ContentFragment.this.getActivity() , android.R.layout.simple_list_item_1, homeOperation.title_list);
//
//        lv.setAdapter(arrayAdapter);

        //addButton onClick
        ImageButton addButton = (ImageButton) view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                addPaige(view);
            }
        });

        return view;
    }

    public void addPaige(View v){
        Intent goToAddPaige = new Intent(getActivity(), AddPaige.class);
        startActivity(goToAddPaige);
    }

    private static class ViewHandler extends Handler {
        private final WeakReference<ContentFragment> mFragment;

        ViewHandler(ContentFragment fragment) {
            mFragment = new WeakReference<ContentFragment>(fragment);
        }

        @Override
        public void handleMessage(Message msg) {
            ContentFragment fragment = mFragment.get();
            if (fragment != null) {
                fragment.handleMessage(msg);
            }
        }
    }

    private void handleMessage(Message msg) {
        if (msg.what == 0) {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ContentFragment.this.getActivity() , android.R.layout.simple_list_item_1, homeOperation.title_list);

            lv.setAdapter(arrayAdapter);
        }
    }
}