int grams, mgrams;
double gw;
TextView TV2;
public void goldWeight(){
    Dialog dialog = new Dialog(HomeActivity.this);
    dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
    dialog.setContentView(R.layout.gold_w_grm);
    dialog.setTitle("GOLD WEIGHT[Grams]");
    dialog.setCancelable(true);

    NumberPicker np1=(NumberPicker)dialog.findViewById(R.id.grm);
    np1.setMaxValue(9999);
    np1.setMinValue(0000);
    //set the last value
    np1.setValue(grams);

    NumberPicker np2=(NumberPicker)dialog.findViewById(R.id.mgrm);
    np2.setMaxValue(9999);
    np2.setMinValue(0000);
    //set the last value
    np2.setValue(mgrams);

    TV2 = (TextView)findViewById(R.id.UserGoldWeight);

    np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int i, int i1) {
            grams= numberPicker.getValue();
            changeTextView();
        }
    });
    np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int i, int i1) {
            mgrams= numberPicker.getValue();
            changeTextView();
        }
    });


    dialog.show();
}

void changeTextView(){
    //             mgrams/100f -> its float and not able to do more than 3 decimal number
    //gw = grams+(mgrams/100f);
    gw = grams+(((double)mgrams)/10000);
    //to be precise, convert it to decimal format (rounding), already tested and works perfectly on my device
    DecimalFormat df = new DecimalFormat("#.####");
    df.setRoundingMode(RoundingMode.CEILING);

    String value = "" + df.format(gw);
    TV2.setText(value);
}