@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_income_dialog, null);
    netPay = (TextView) view.findViewById(R.id.tvNetPay);
    insuranceRelief = (TextView) view.findViewById(R.id.tvPersonalRelief);

    Bundle bundle=getArguments();
    int i = bundle.getInt("key1");
    int f = bundle.getInt("key2");

    return view;
}