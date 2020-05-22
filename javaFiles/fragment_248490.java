@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    Button calc = (Button) view.findViewById(R.id.btnCalculate);
    final EditText num = (EditText) view.findViewById(R.id.num);
    final TextView display = (TextView) view.findViewById(R.id.display);
    calc.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            double number = Double.parseDouble(num.getText().toString());
            number = number * 5;
            display.setText(number + "");
        }
    });

    return view;
}