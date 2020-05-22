startDaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(final AdapterView<?> adapterView, View view, int i, long l) {


            DateFormat currentDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            startDayString = currentDateFormat.format(new Date());

            switch (i) {
                case 0:

                    startDayString = currentDateFormat.format(new Date());
                    break;

                case 1:

                    Calendar calendar = Calendar.getInstance();

                    calendar.add(Calendar.DAY_OF_YEAR, 1);
                    Date tomorrow = calendar.getTime();

                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    startDayString = dateFormat.format(tomorrow);
                    break;

                case 2:
                    final Calendar c = Calendar.getInstance();
                    mYearStartE = c.get(Calendar.YEAR);
                    mMonthStartE = c.get(Calendar.MONTH);
                    mDayStartE = c.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(PurchaseActivity.this,
                            new DatePickerDialog.OnDateSetListener() {

                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {

                                    startDayString = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;

                                    Toast.makeText(getBaseContext(), "startDayString: " + startDayString, Toast.LENGTH_SHORT).show();

                                    TextView mTextView = (TextView) adapterView.getSelectedView();
                                    mTextView.setText(startDayString);
                                }
                            }, mYearStartE, mMonthStartE, mDayStartE);
                    datePickerDialog.show();
                    break;
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });