pick_date.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View view)
    {
        if((fixed_date_flag).isChecked()){
            Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(NewActivity.this, NewActivity.this, year, month, day);
            datePickerDialog.show();
         }
    }
});