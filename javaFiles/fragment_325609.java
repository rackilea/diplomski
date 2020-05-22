public static MatchDetailSummaryFragment newInstance(String matchIdString, int position) {
    MyFragment fragment = new MyFragment();
    Bundle args = new Bundle();
    args.putString(ARGS_MY_ID, matchIdString);
    args.putInt(ARG_POSITION,position);
    fragment.setArguments(args);
    return fragment;
}

public MyFragment() {
    // Required empty public constructor
}

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    this.mPosition = getArguments().getInt(ARG_POSITION);
    this.id = getArguments().getString(ARGS_MY_ID) != null)
}