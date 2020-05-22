final View confirmation=inflater.inflate(R.layout.confirmation,null);
  pin  = (EditText) confirmation.findViewById(R.id.PinChecker);

....


SendPointsButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setView(confirmation);

        builder.setPositiveButton("DA", new    DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                pinCheck= String.valueOf(pin.getText().toString());
                Log.d("Pin",pinCheck);
}