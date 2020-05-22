@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ........
    ...............

    fSearch = new FragmentSearch();
    froute = new FragmentRoute();
    fHelp = new FragmentHelp();
    fSettings = new FragmentSettings();
    fSearchRoute = new FragmentSearchRoute();

    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    int selectedPosition = sharedPreferences.getInt("SELECTED_POSITION", 1);

    switch (selectedPosition) {
        case 1:
            // FragmentSearch
            getFragmentManager().beginTransaction().replace(R.id.container, fSearch).commit();            
            break;
        case 2:
            // FragmentRoute
            getFragmentManager().beginTransaction().replace(R.id.container, froute).commit();            
            break;
        case 3:
            // FragmentHelp
            getFragmentManager().beginTransaction().replace(R.id.container, fHelp).commit();            
            break;                       
        default:
            getFragmentManager().beginTransaction().replace(R.id.container, fSearch).commit(); 
            break;
    }

}