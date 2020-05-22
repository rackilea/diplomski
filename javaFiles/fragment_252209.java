@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = getActivity().getApplicationContext();

        ((MainFragmentActivity) getActivity()).setupActionBar(R.string.title_fragment_feed);

        fbSessionsManager = new FBSessionsManager(getActivity());

        if (mList == null){
            view = inflater.inflate(R.layout.feed_flipview, container,true);
            mFlipView = (FlipView) view.findViewById(R.id.fv_feedFlipView_FlipView);
            mFlipView.setOnFlipListener(this);
            mFlipView.setOverFlipMode(OverFlipMode.RUBBER_BAND);
            mFlipView.setEmptyView(view.findViewById(R.id.empty_view));
            mFlipView.setOnOverFlipListener(this);
            new LoadFeedPrincipalData().execute();
        }

        return super.onCreateView(inflater,container,savedInstanceState);
    }