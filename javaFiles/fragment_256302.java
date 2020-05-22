@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    Constants.listeners.add(this);
    View v = inflater.inflate(R.layout.fragment_auction_current_tab, null);
    ButterKnife.bind(this, v);
    context = getActivity();
    handler = new Handler();
    list = v.findViewById(R.id.list);
    prefsUtils = new PrefsUtils(getActivity());
    apis = ApiClient.getClient().create(APIs.class);
    swipeToRefresh = v.findViewById(R.id.swipeToRefresh);

    jwtToken = Constants.settings.getString("jwt_token", "");

    list_item = getActivity().findViewById(R.id.list_item);
    linearLayoutManager = new LinearLayoutManager(context);
    auctionListAdapter = new AuctionsListAdapter(context, todayModel, R.layout.list_item_auction_normal_new);
    list.setLayoutManager(linearLayoutManager);
    list.setHasFixedSize(true);
    list.setAdapter(auctionListAdapter);
    list.setOnScrollListener(new EndlessRecyclerLinearPage(linearLayoutManager) {
        @Override
        public void onLoadMore(final int current_page) {
            miniLoader.setVisibility(View.VISIBLE);
            getData(currentPage);
        }
    });
    getData(1);
    swipeToRefresh.setColorSchemeResources(R.color.colorAccent);
    swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            getData(1);
        }
    });

    return v;
}

private void getData(int page) {
    Call<AuctionsListResponse> call = apis.getTodatAuctions(jwtToken, page, 10);
    call.enqueue(new Callback<AuctionsListResponse>() {
        @Override
        public void onResponse(Call<AuctionsListResponse> call, Response<AuctionsListResponse> response) {
            if (response.isSuccessful()) {
                if (response.body() != null) {
                    if (response.body().getRes() != null) {
                        if (response.body().getRes().getToday().size() > 0 && response.body().getRes().getToday() != null) {
                            todayModel.clear();
                            todayModel
                                 .addAll(response.body()
                                                 .getRes()
                                                 .getToday());

                            //NOTICE THE DIFFERENCE HERE
                            auctionListAdapter.setModel(todayModel);
                            auctionListAdapter.notifyDataSetChanged();
                            itemsLoader.setVisibility(View.GONE);
                            if (swipeToRefresh != null) {
                                swipeToRefresh.setRefreshing(false);
                            }
                            miniLoader.setVisibility(View.GONE);
                        }
                    }
                }
            }
        }

        @Override
        public void onFailure(Call<AuctionsListResponse> call, Throwable t) {
             itemsLoader.setVisibility(View.GONE);
             if (swipeToRefresh != null) {
                swipeToRefresh.setRefreshing(false);
             }
             miniLoader.setVisibility(View.GONE);
        }
    });
}