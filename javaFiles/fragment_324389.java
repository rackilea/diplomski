@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    SessionManager sessionManager = new SessionManager(getActivity());

    // Considering you have the function to store and retrieve the login name from the SharedPreferences in your SessionManager class. 
    String loginName = sessionManager.getLoginName(); // get the login name here

    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_profile, container, false);
}