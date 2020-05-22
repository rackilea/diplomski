@Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
      int position = FragmentPagerItem.getPosition(getArguments());

    switch (position){
        case 0: return inflater.inflate(R.layout.fragment_strucne, container, false);
        case 1: return inflater.inflate(R.layout.fragment_opis, container, false);
        case 2:     View rootView =inflater.inflate(R.layout.fragment_poloha, container, false);
                    SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map2);
                    mapFragment.getMapAsync(this);
                return rootView;
        case 3: return inflater.inflate(R.layout.fragment_kontakt, container, false);
    }
    return inflater.inflate(R.layout.fragment_strucne, container, false);
  }