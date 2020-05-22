@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
    // Initialize your stuff here
    setupUI(view);
    return view;
}

private void setupUI(View view) {
    rellay_timeline = view.findViewById(R.id.rellay_timeline);
    rellay_friends = view.findViewById(R.id.rellay_friends);
    rellay_chat = view.findViewById(R.id.rellay_chat);

    // The rest of the initialization code goes here...
}