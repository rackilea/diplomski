@Override
public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.setup_fragment,container,false);
    Button logout = (Button)root.findViewById(R.id.logout_button);
    logout.setOnClickListener(new OnClickListener() {

        public void onClick(View view) {
            // Logout current user
            ParseUser.logOut();
            startActivity(new Intent((ParentActivity)getActivity(), SignUpOrLogInActivity.class));

        }

    });
  return root;
}