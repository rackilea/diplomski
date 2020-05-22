btnAdd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        LinearLayout newLinear = new LinearLayout(AddSpinnerDynamicallyActivity.this);


        Spinner newSpinner = new Spinner(AddSpinnerDynamicallyActivity.this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                AddSpinnerDynamicallyActivity.this, R.array.question_type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        newSpinner.setAdapter(adapter);


        newLinear.addView(newSpinner);


        setContentView(newLinear);
    }});