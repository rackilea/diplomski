holder.valueLabel.setOnClickListener(view -> {
            if (item.value.equals(""))
                try {
                    String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                    holder.valueLabel.setText(date);
                    mItems.get(position).value = date;
                    DatePickerDialog datePickerDialog = showDatePickerDialog(holder.valueLabel.getText().toString(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            String dateInFormat = getDateInFormat(year, month, day);
                            holder.valueLabel.setText(dateInFormat);
                            mItems.get(position).value = dateInFormat;
                        }

                    });
                    datePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "cancel", (dialog, which) -> {
                        holder.valueLabel.setText("");
                        mItems.get(position).value = "";
                    });
                    datePickerDialog.show();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            else {
                try {
                    showDatePickerDialog(holder.valueLabel.getText().toString(), (datePicker, year, month, day) -> {
                        String dateInFormat = getDateInFormat(year, month, day);
                        holder.valueLabel.setText(dateInFormat);
                        mItems.get(position).value = dateInFormat;
                    }).show();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });