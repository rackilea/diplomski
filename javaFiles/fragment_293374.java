View rootView = inflater.inflate(R.layout.level_auswahl, container, false);
    //the view here should be the one which inflates the layout which contains your toolbar. 
    //I assume it is rootview which u mentioned just above this line. 
    Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
    toolbar.setTitle("Title");
    toolbar.setNavigationIcon(R.drawable.backarrow1);
    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

           //achieve your behaviour here
        }
    });
    return rootView;