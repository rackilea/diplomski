@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.your_fragment, container, false);
}

@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
     super.onViewCreated(view, savedInstanceState);
    final String MY_PREFS_NAME = "MyPrefsFile";
     SharedPreferences shared = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE); 
     String url = shared.getString("name",null); 

     final WebView view=(WebView) view.findViewById(R.id.webView);
     view.loadUrl(url);

}