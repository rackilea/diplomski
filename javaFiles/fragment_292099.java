spinner_dailyInput.setAdapter(adapter3);
    spinner_dailyInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (position){

                case 1:
                    for(int i=0;i<1;i++) {
                        setTimePicker(i);
                        //clock1=time; <--- wrong. time is still null here
                    }

                    break;
                    }
        }
    }

     public void setTimePicker(final int i){
            Calendar mcurrentTime = Calendar.getInstance();
            final int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
            int minute = mcurrentTime.get(Calendar.MINUTE);
            TimePickerDialog mTimePicker;
            mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                    hr=String.valueOf(selectedHour);
                    mini=String.valueOf(selectedMinute);
                    time=hr+":"+mini;
                    Log.e(TAG+".........TimePicker.....................",time+"");
                mySimpleCallback(i, time)';//<---- not null here
                }
            }, hour, minute, true);
            mTimePicker.setTitle("Select Time");
            mTimePicker.show();

        }


    private void mySimpleCallback(int i, String time ) {
    //not null here because it fires after your code execution
if (i == 0)
    clock1 = time;
else
clock2 = time;
    }