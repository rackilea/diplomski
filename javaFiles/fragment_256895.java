private SharedPreferences pref;

@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    pref = PreferenceManager.getDefaultSharedPreferences(getContext());

    return inflater.inflate(R.layout.fragment_rostering, container, false);
}

public void onBackPressed() {
    SharedPreferences.Editor editor = pref.edit();
    editor.putBoolean(Constants.REFRESH, true);
    editor.commit();
    super.onBackPressed();
}