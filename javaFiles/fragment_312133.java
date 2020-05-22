@Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
   View rootView = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

   ListView mDrawerListView = (ListView) rootView.findViewById(R.id.listView);
   mDrawerList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    // Other stuff
   return rootView; 
 }