@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        ...
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        switch (args.getInt(ARG_SECTION_NUMBER)){
        case 1: 

            break;
        case 2:
            Button btncoursesAjoutListe = (Button) getActivity().findViewById(R.id.coursesAjoutListe);
            ListView lvlistViewCoursesListe = (ListView) getActivity().findViewById(R.id.listViewCoursesListe);

            btncoursesAjoutListe.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    PopulateListview(lvlistViewCoursesListe)
                }
            });
        case 3:

            break;
        case 4:

            break;
        }



    }