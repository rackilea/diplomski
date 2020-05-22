@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_feeds, container, false);

        newsFeedList = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final NewsAdapter mAdapter = new NewsAdapter(getActivity(), newsFeedList);
        recyclerView.setAdapter(mAdapter);

        LoadJSONAsyncTask asyncTask = new LoadJSONAsyncTask() {
        @Override
        void onPostExecute(ArrayList<String> results) {
                // update your adapter here with the result

                for(int i = 0; i < results.size(); i++)
                {
                    newsFeedList.add(new NewsFeed(results.get(i)));
                }

                // notify adapter here to update the view
                mAdapter.notifyDataSetChanged()
            }
        }

        asyncTask.execute(url);

        return view;
    }