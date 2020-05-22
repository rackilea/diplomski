s1.setOnItemSelectedListener(new OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> arg0,View arg1, int arg2, long arg3) {
                int index = s1.getSelectedItemPosition();
                if(index>0)
                {
                             String Month = MonthArray[index];
                    if ( Month.equalIgnoreCase("August")) {

                        startActivity(new Intent(date.this,MainActivity.class));
                    }
                    else{
                        startActivity(new Intent(date.this,august
                                .class));

                    }
                }
            }
            public void onNothingSelected(AdapterView<?>arg0) {}
        });