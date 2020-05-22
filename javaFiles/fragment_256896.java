private SharedPreferences pref;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    pref = PreferenceManager.getDefaultSharedPreferences(getContext());

    return inflater.inflate(R.layout.fragment_profile, container, false);
}

@Override
public void onResume() {
    super.onResume();
    if(pref.getBoolean(Constants.REFRESH, false)){
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(Constants.REFRESH, false);
        editor.commit();
        refreshFragment();
    }
}