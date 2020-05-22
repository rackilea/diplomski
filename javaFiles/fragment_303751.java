@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View loginFragmentView = inflater.inflate(R.layout.login_layout, container, false);
        return loginFragmentView;
    }


  @Override
  public void onViewCreated(View loginFragmentView, Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);

      TextView imei = (TextView) loginFragmentView.findViewById(R.id.txt_device_id);
      imei.setText("IMEI: ");
  }