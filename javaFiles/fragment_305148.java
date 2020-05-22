@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        view_details = (ViewGroup) inflater.inflate( R.layout.details, container , false);
        TextView txt_view_details = (TextView) view_details.findViewById(R.id.txt_details);
        txt_view_details.setText(getArguments().getString("title"));
        return view_details;

    }