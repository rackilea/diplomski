spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(getBaseContext(),adapterView.getItemAtPosition(i)+" Selected",Toast.LENGTH_LONG).show();

            if(i==0){
                Intent  intent = new Intent(YourActivity.this, WebViewActivity.class);
                intent.putExtra("URl","https://stackoverflow.com/");
                startActivity(intent);
            }else if(i==1){
                Intent  intent = new Intent(YourActivity.this, WebViewActivity.class);
                intent.putExtra("URl","https://stackoverflow.com/");
                startActivity(intent);
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });