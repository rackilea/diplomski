@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.your_t7_contain_layout, container, false);
        TextView tv = (TextView) view.findViewById(R.id.tv);
        Button btn = (Button) view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                              //your btn action
                    }
        });

        return view;
    }//End of onCreateView