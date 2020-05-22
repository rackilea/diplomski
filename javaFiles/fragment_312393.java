final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int  mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(ConstarintsActivity.this,
                    (view, year, monthOfYear, dayOfMonth) -> {


                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
            datePickerDialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(Color.GREEN);