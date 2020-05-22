[...]
private String selectedTeam;
[...]

//Adding setOnItemSelectedListener method on spinner.
    sTeams.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int position, long id) {
            selectedTeam = parent.getItemAtPosition(position).toString();
            editText.setText(selectedTeam, TextView.BufferType.EDITABLE);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    });

    buttonApply.setOnClickListener(new Button.OnClickListener() {
        public void onClick(View v) {
            String editedName = editText.getText().toString();
            if (selectedTeam != null && !"".equals(selectedTeam)) {
                // Do something
            }
        }
    });