public class SomeClass extends Activity {

  private static final String KEY = "some_key";

  commodities;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragments_stops_list, container, false);
        ButterKnife.bind(this, view); // since this is a fragment the butterknife bind method should goafter the view declaration
        // saved state would indicate that we are now not capable of making multiple requests. This point has been
        // properly taken care of and now I can purposely move on to other things of more importance
        loadButton = (Button) view.findViewById(R.id.LOAD);
        if(savedInstanceState == null) {
            loadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(">==========<", extractCreate.getCreateR().getPhone());
                    Parcelable[] parcelable = extractCreate.getStopsR();
                    commodities = Arrays.copyOf(parcelable, parcelable.length, Stops[].class);
                    //Log.d("Commodities size check", String.valueOf(commodities.length));


                    StopsAdapter adapter = new StopsAdapter(commodities);
                    mRecyclerView.setAdapter(adapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity()); // sketchy on this part
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    Log.d(TAG, "This is being called from the onCreate method");


                }
            });
        } else {
          if(savedInstanceState.containsKey(KEY)) {
            commodities = savedInstanceState.getParcelable(KEY);
            // here you will pretty much repete the code from above
            // for creating an Adapter for the RecyclerView
                    StopsAdapter adapter = new StopsAdapter(commodities);
                    mRecyclerView.setAdapter(adapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity()); // sketchy on this part
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
          }
        }
        return view;
    }

      @Override
      public void onSaveInstanceState(Bundle outState) {
         super.onSaveInstanceState(outState);
         outState.putParcelable(KEY, commodities);
      }

}