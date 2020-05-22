View rootView; // this is one variable
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        // this is not the same rootView !
        // here, rootView != this.rootView
        initFonts();
        return rootView;
    }

public void initFonts(){
    TextView tv_title = (TextView) rootView.findViewById(R.id.tv_about_title);
    // this is like using this.rootView.findViewById
    // ...
}