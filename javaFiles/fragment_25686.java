public Double ac; // global variable

@Override
public void onCreate(Bundle savedInstanceState){

Button Calculate = (Button) theLayout.findViewById(R.id.button);
Button buttonb = (Button) theLayout.findViewById(R.id.buttonb);
final TextView tvac = (TextView) theLayout.findViewById(R.id.tvac);
final TextView tvh = (TextView) theLayout.findViewById(R.id.tvh);
final EditText eta = (EditText) theLayout.findViewById(R.id.eta);
final EditText etn = (EditText) theLayout.findViewById(R.id.etn);
final EditText etb = (EditText) theLayout.findViewById(R.id.etb);

Calculate.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v)
    {
        Double a = new Double(eta.getText().toString());
        Double n = new Double(etn.getText().toString());
        ac = a*n;
        tvac.setText(getResources().getString(R.string.tvresultados2) + " " + ac);
    }
});
buttonb.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v) {
        double b = new Double(etb.getText().toString());
        double h = ac;          //assign global variable into h
        tvh.setVisibility(View.VISIBLE);
        tvh.setText("h = " + h);
    }
});

}