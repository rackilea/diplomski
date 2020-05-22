public class news extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Deatails> data;
    private DataAdapter adapter;
    private View myFragmentView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        myFragmentView= inflater.inflate(R.layout.news, container, false);
        initViews();
        return myFragmentView;
    }

    private void initViews() {

        recyclerView = (RecyclerView)myFragmentView.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON() {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://memaraneha.ir/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            RequestInterface request = retrofit.create(RequestInterface.class);
            Call<JSONResponse> call = request.getJSON();

            final ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.show();

            call.enqueue(new Callback<JSONResponse>() {
                @Override
                public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                    progressDialog.dismiss();

                    JSONResponse jsonResponse = response.body();
                    data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                    adapter = new DataAdapter(getActivity(), data);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<JSONResponse> call, Throwable t) {
                    progressDialog.dismiss();
                    Log.d("Error", t.getMessage());
                }
            });
    }
}