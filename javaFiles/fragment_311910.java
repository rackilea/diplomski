@Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            SharedPreferences sendnumber = getSharedPreferences("name", MODE_PRIVATE);
            SharedPreferences.Editor editor = sendnumber.edit();
            editor.putString("edtTextValue", pro);
            editor.commit();

            return;
        }