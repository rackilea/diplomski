TextWatcher tw = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // TODO Auto-generated method stub

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {
            // TODO Auto-generated method stub

        }

        @Override
        public void afterTextChanged(Editable s) {
            //get values in editText1 and 2 and add them

int val1 = Integer.parseInt(editText1.getText().toString());
int val2 = Integer.parseInt(editText2.getText().toString());

//add the above code here

String finalDate = day + " " + month + " " + year; 

SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

Calendar c = Calendar.getInstance();

try {
    c.setTime(sdf.parse(finalDate));
} catch (ParseException e) {
    e.printStackTrace();
}

String addDays = Integer.parseInt(editText2.getText().toString());

c.add(Calendar.DATE, addDays);  // number of days to add
SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMMM yyyy");
String output = sdf1.format(c.getTime());

    editText3.setText(output + "");


        }
    };