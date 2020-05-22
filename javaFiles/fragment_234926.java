@Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);

    template=getActivity().getString(R.string.url);
    mgr=(LocationManager)getActivity()
      .getSystemService(Context.LOCATION_SERVICE);
  }