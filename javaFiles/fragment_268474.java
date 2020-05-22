@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
{
    View rootview = inflater.inflate(R.layout.fragment_log, container, false);

    Fragment navigationFrag = new NavigationFrag();
    FragmentTransaction trans1 = getChildFragmentManager().beginTransaction();
    trans1.add(R.id.navigationFrag, navigationFrag).commit();

    final Fragment footerFragment = new FooterFragment();
    FragmentTransaction trans2 = getChildFragmentManager().beginTransaction();
    trans2.add(R.id.footerFragment, footerFragment).commit();

    Button btn1 = (Button)rootview.findViewById(R.id.button1);
    btn1.setOnClickListener( new OnClickListener(){
        @Override
        public void onClick(View v) {
            TextView txv = (TextView)footerFragment.getView().findViewById(R.id.logInfo);
            txv.setText("Updated log of Footer");
        }
    });

    return rootview;
}