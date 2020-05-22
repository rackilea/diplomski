View RootView;//Global
    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) { 

         RootView = inflater.inflate(R.layout.fragment_v, container, false);
         initViews();
         return RootView;
    }

     private void initViews(){
            recyclerView = (RecyclerView)RootView.findViewById(R.id.card_recycler_view);
            recyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);
            loadJSON();
        }