@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.server_settings, container, false);
    final Button loginButton = (Button) view.findViewById(R.id.addServerSettingsbtn);
    loginButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(final View v) {
            //were the magic won't happen.
        }
    });
    return view;
}