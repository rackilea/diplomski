public void onAddField(View v) {
    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final View rowView = inflater.inflate(R.layout.field, null);
    ((EditText) rowView.findViewById(R.id.number_edit_text1)).addTextChangedListener(new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            ((TextView) rowView.findViewById(R.id.number_text_view)).setText(
                    avg(((EditText) rowView.findViewById(R.id.number_edit_text1)),
                            ((EditText) rowView.findViewById(R.id.number_edit_text2)),
                            ((EditText) rowView.findViewById(R.id.number_edit_text3))));            }

        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
        }
    });

    ((EditText) rowView.findViewById(R.id.number_edit_text2)).addTextChangedListener(new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub

        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            ((TextView) rowView.findViewById(R.id.number_text_view)).setText(
                    avg(((EditText) rowView.findViewById(R.id.number_edit_text1)),
                            ((EditText) rowView.findViewById(R.id.number_edit_text2)),
                            ((EditText) rowView.findViewById(R.id.number_edit_text3))));
        }

        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub

        }
    });
    ((EditText) rowView.findViewById(R.id.number_edit_text3)).addTextChangedListener(new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub

        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            ((TextView) rowView.findViewById(R.id.number_text_view)).setText(
                    avg(((EditText) rowView.findViewById(R.id.number_edit_text1)),
                            ((EditText) rowView.findViewById(R.id.number_edit_text2)),
                            ((EditText) rowView.findViewById(R.id.number_edit_text3))));

        }

        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub

        }
    });
    // Add the new row before the add field button.
    parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);


}

private String avg(EditText viewById, EditText viewById1, EditText viewById2) {
    int number1;
    int number2;
    int number3;
    if (viewById.getText().toString() != "" && viewById.getText().length() > 0) {
        number1 = Integer.parseInt(viewById.getText().toString());
    } else {
        number1 = 0;
    }
    if (viewById1.getText().toString() != "" && viewById1.getText().length() > 0) {
        number2 = Integer.parseInt(viewById1.getText().toString());
    } else {
        number2 = 0;
    }
    if (viewById2.getText().toString() != "" && viewById2.getText().length() > 0) {
        number3 = Integer.parseInt(viewById2.getText().toString());
    } else {
        number3 = 0;
    }

    return Integer.toString((number1 + number2 + number3) / 3);
}