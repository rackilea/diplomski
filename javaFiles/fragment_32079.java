@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.navbar, container, false);

    homeBtn = (Button)view.findViewById(R.id.homeBtn);
    optionsBtn = (Button)view.findViewById(R.id.optionsBtn);
    connectionBtn = (Button)view.findViewById(R.id.micBtn);
    micBtn = (Button)view.findViewById(R.id.homeBtn);
    aboutBtn = (Button)view.findViewById(R.id.aboutBtn);

    return view;
}