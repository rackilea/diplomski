private boolean mFirstSelect = true; //make this a field

areaspinner.setOnItemSelectedListener(new OnItemSelectedListener() {

        public void onItemSelected(AdapterView<?> arg0, View arg1,
                int arg2, long arg3) {
            if (mFirstSelect)
            {
                  mFirstSelect = false;
                  return;
            }
            int item = areaspinner.getSelectedItemPosition();

                Bundle bundle = new Bundle();
                bundle.putInt("selection", item);

                   Intent myIntent = new Intent(patriosar.this, ShowXMLPAR.class);
                   myIntent.putExtras(bundle);
                   startActivityForResult(myIntent, 0);




        }

        public void onNothingSelected(AdapterView<?> parent) {
        }