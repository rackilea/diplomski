@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.ppl_details_form,container,false);
        PPL_Title_Spinner= (Spinner) view.findViewById(R.id.PPL_Spinner);
        Title= (EditText) view.findViewById(R.id.ppl_title);
        Address= (AutoCompleteTextView) view.findViewById(R.id.ppl_address);
        Year= (EditText) view.findViewById(R.id.ppl_passing_year);
        Description= (EditText) view.findViewById(R.id.ppl_description);
        btn1= (Button) view.findViewById(R.id.ppl_map_button);

        Save= (Button) view.findViewById(R.id.ppl_save);
        Save_PPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title=Title.getText().toString();
                address= Address.getText().toString();
                year=Year.getText().toString();
                description=Description.getText().toString();
                //PPL Wrapper
                PPL_list_wrapper list=new PPL_list_wrapper(title,year,address);

                Add_PPL=(PPL_transfer_data_to_list)getActivity();
                Add_PPL.addLocation(list);
                fragment_1 fragment1=new fragment_1();
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.Navigation_Main_Layout,fragment1);
                fragmentTransaction.commit();

            }
        });


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            Add_PPL= (PPL_transfer_data_to_list) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString()+" Must Implement Interface");
        }
    }