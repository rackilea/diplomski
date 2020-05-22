@Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

      View myView = inflater.inflate(R.layout.fragment_home, container,
         false);


   label= (TextView) myView.findViewById(R.id.section_label);

ImageButton btn = (ImageButton) myView.findViewById(R.id.AddItems);
            btn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
//Call the Activity method where you add fragments
                ((appMain)getActivity()).loadSelection(4);

                }
            });

          return myView;


       }