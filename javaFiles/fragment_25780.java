public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View v= inflater.inflate(R.layout.tab_fragment_2, container, false);

        //to get view like textview, button etc use v.findViewById(yourid)

        TextView textView = v.findViewById(R.id.textView2);
        return v;
    }
}.