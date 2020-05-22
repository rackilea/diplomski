@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

View view = inflater.inflate(R.layout.fragment_amount, null);

EditText amountField = (EditText) view.findViewById(R.id.fragment_amount_edit);
amountField.setError("ERRROROROROR");

    return view;
}