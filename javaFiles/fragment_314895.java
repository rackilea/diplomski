@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view  =  inflater.inflate(R.layout.fragment_settings, container, false);

    //Logout button interaction
    Button logoutButton = (Button) view.findViewById(R.id.logoutButton);

    //Set onclick listener for the logout button
    logoutButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Deleting shared preferences for login activity
            SharedPreferences loginPreferences = getActivity().getSharedPreferences("loginPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = loginPreferences.edit();
            editor.clear();
            editor.commit();
            getActivity().finish();

            // Launching login activity screen
            Intent intentLogout = new Intent(getActivity(), LoginActivity.class);
            SettingsFragment.this.startActivity(intentLogout);
        }

        ;
    });

    return view;
}