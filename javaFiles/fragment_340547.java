public static SupportMapFragment newInstance() {
    SupportMapFragment fragment = new SupportMapFragment();
    Bundle args = new Bundle();
    args.putBoolean("secretOptionNotEnabledWithNormalConstructor", true);
    fragment.setArguments(args);
    return fragment;
}